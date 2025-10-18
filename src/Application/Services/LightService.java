package Application.Services;

import Application.*;
import Application.Enums.LightOption;
import Devices.Light;
import Enums.LightState;
import Enums.MusicVolume;
import LightTypes.*;
import org.ietf.jgss.GSSContext;

import java.util.Scanner;

public class LightService extends Service
{
    private Light currentLight;

    public LightService(Application application  ) {
        super(application);
    }

    @Override
    public void Open(Scanner scanner) {
        while(true)
        {
            LightOption lightOption = displayLightListOptions(scanner);

            handleLightOption(lightOption , scanner);
        }
    }

    public void Open(Scanner scanner,Light currentLight)
    {
        this.currentLight = currentLight;
        while (true)
        {
            LightOption lightOption = displayLightListOptions(scanner);

            handleLightOption(lightOption , scanner);
        }
    }

    private LightOption displayLightListOptions(Scanner scanner)
    {
        System.out.println("\n=== Меню Управления Освещением #" + currentLight.getId() + " (" + currentLight.getLightType().getType() + ") ===");
        System.out.println("1. Запустить");
        System.out.println("2. Поменять Яркость");
        System.out.println("3. Заменить Освещение");
        System.out.println("4. Выключить");
        System.out.println("5. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 5);
        return LightOption.fromValue(choice);
    }

    private void handleLightOption(LightOption lightOption , Scanner scanner)
    {
        switch (lightOption)
        {
            case CHANGE_LIGHT -> currentLight.changeLightType(onSetLightType(scanner));
            case CHANGE_STATE ->  currentLight.changeState(onChangeState(scanner));
            case OPERATE -> System.out.println(currentLight.operate());
            case TURN_OFF -> System.out.println(currentLight.turnOf());
            case EXIT -> getApplication().getLightListService().Open(scanner);
        }
    }

    private LightType onSetLightType(Scanner scanner)
    {
        System.out.println("=== Выберите новый тип освещения для Light #" + currentLight.getId() + " ===");
        System.out.println("1. Галогенная лампа");
        System.out.println("2. Лампа накаливания");
        System.out.println("3. LED");
        System.out.println("4. Люминисцентная Лампа");
        System.out.println("5. Пусто");
        System.out.println("6. Отмена");

        int choice = InputValidator.getIntInput(scanner, 1, 6);

        if (choice == 6) Open(scanner);

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

    private LightState onChangeState(Scanner scanner)
    {
        System.out.println("\n=== Выберите Яркость ===");
        System.out.println("1. Яркий");
        System.out.println("2. Тусклый");
        System.out.println("3. Выключенн");
        System.out.println("4. Отмена");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 4);

        if(choice == 4) Open(scanner);
        return LightState.fromValue(choice);
    }

    public void setCurrentLight(Light currentLight)
    {
        this.currentLight = currentLight;
    }
}
