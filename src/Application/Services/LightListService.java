package Application.Services;

import Application.*;
import Application.Enums.LightListOption;
import Builders.LightBuilder;
import Devices.Light;
import LightTypes.*;

import java.util.Scanner;

public class LightListService extends Service
{

    public LightListService(Application application) {
        super(application);
    }

    @Override
    public void Open(Scanner scanner)
    {
        while(true)
        {
            LightListOption option = displayLightListOptions(scanner);

            handleLightListOption(option , scanner);
        }
    }

    private LightListOption  displayLightListOptions(Scanner scanner)
    {
        System.out.println("\n=== Главное меню Управления Освещением ===");
        System.out.println("1. Добавить новый источник света");
        System.out.println("2. Удалить источник света по Id");
        System.out.println("3. Показать все источники света");
        System.out.println("4. Управлять конкретным источником света");
        System.out.println("5. Запустить все источники света");
        System.out.println("6. Выключить все источники света");
        System.out.println("7. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 7);
        return LightListOption.fromValue(choice);
    }

    private void handleLightListOption(LightListOption option , Scanner scanner)
    {
        switch (option)
        {
            case ADD_NEW_LIGHT -> getApplication().getDeviceStorage().addNewLight(onAddNewLight(scanner));
            case REMOVE_LIGHT -> getApplication().getDeviceStorage().removeLightById(onRemoveCamera(scanner));
            case GET_LIGHT_LIST -> showLightList();
            case SELECT_LIGHT -> getApplication().getLightService().Open(scanner ,getApplication().getDeviceStorage().getLightById(onSelectLight(scanner)));
            case OPERATE -> getApplication().getDeviceStorage().getLights().forEach(light -> {
                System.out.println(light.operate());
            });
            case TURN_OFF -> getApplication().getDeviceStorage().getLights().forEach(light -> {
                System.out.println(light.turnOf());
            });
            case EXIT -> getApplication().Run();
        }
    }

    private Light onAddNewLight(Scanner scanner)
    {
        LightBuilder lightBuilder = new LightBuilder();
        lightBuilder.AddLightType(onSetLightType(scanner));
        Light light = lightBuilder.build();
        System.out.println("New Light #" + light.getId() + " (" + light.getLightType().getType() + ") created.");
        return light;
    }

    private int onSelectLight(Scanner scanner)
    {
        showLightList();

        System.out.print("Select Light #");

        return InputValidator.getIntInput(scanner, 1, Light.getMaxId());
    }

    private LightType onSetLightType(Scanner scanner)
    {
        System.out.println("=== Выберите тип освещения ===");
        System.out.println("1. Галогенная лампа");
        System.out.println("2. Лампа накаливания");
        System.out.println("3. LED");
        System.out.println("4. Люминисцентная Лампа");
        System.out.println("5. Пусто");

        int choice = InputValidator.getIntInput(scanner, 1, 5);

        return switch (choice)
        {
            case 1 -> new HalogenLamp();
            case 2 -> new IncandescentLamp();
            case 3 -> new LED();
            case 4 -> new LuminescentLamp();
            case 5 -> new Empty();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    private int onRemoveCamera(Scanner scanner)
    {
        showLightList();

        System.out.print("Введите ID освещения которого хотите убрать:");
        return InputValidator.getIntInput(scanner, 1, Light.getMaxId());
    }

    private void showLightList()
    {
        int i = 1;
        for(Light light : getApplication().getDeviceStorage().getLights())
        {
            System.out.println(i + ".Light #" + light.getId() + " (" + light.getLightType().getType() + ")");
            i++;
        }
    }
}
