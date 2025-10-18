package Application.Services;

import Application.*;
import Application.Enums.*;
import Enums.*;

import java.util.Scanner;

public class ThermostatService extends Service
{

    public ThermostatService(Application application) {
        super(application);
    }

    @Override
    public void Open(Scanner scanner) {
        while(true){
            ThermostatOption thermostatOption = displayThermostatOptions(scanner);

            handleThermostatOption(thermostatOption , scanner);
        }
    }

    private ThermostatOption displayThermostatOptions(Scanner scanner)
    {
        System.out.println("\n=== Главное меню Управления Термостатом ===");
        System.out.println("1. Запустить");
        System.out.println("2. Сменить Режим");
        System.out.println("3. Утановить Температуру");
        System.out.println("4. Текущая установленная Температура");
        System.out.println("5. Выключить");
        System.out.println("6. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 6);
        return ThermostatOption.fromValue(choice);
    }

    private void handleThermostatOption(ThermostatOption thermostatOption , Scanner scanner)
    {
        switch (thermostatOption)
        {
            case OPERATE -> System.out.println(getApplication().getDeviceStorage().getThermostat().operate());
            case CHANGE_STATE -> getApplication().getDeviceStorage().getThermostat().changeState(onChangeState(scanner));
            case SET_TEMPERATURE -> getApplication().getDeviceStorage().getThermostat().setTemperature(onSetTemperature(scanner));
            case GET_TEMPERATURE ->  System.out.println("Current Temperature is " + getApplication().getDeviceStorage().getThermostat().getTemperature() + "C");
            case TURN_OFF -> System.out.println(getApplication().getDeviceStorage().getThermostat().turnOf());
            case EXIT -> getApplication().Run();
        }
    }

    private ThermostatState onChangeState(Scanner scanner)
    {
        System.out.println("\n=== Выберите Режим Термостата ===");
        System.out.println("1. Производительный");
        System.out.println("2. Обычный");
        System.out.println("3. Экономный");
        System.out.println("4. Выключенный");
        System.out.println("5. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 5);

        if (choice == 5) Open(scanner);
        return ThermostatState.fromValue(choice);
    }

    private float onSetTemperature(Scanner scanner)
    {
        System.out.println("\n=== Установите Температуру Термостата ===");
        System.out.print("Температура (999 to exit): ");

        float choice = InputValidator.getFloatInput(scanner);

        if (choice == 999) Open(scanner);

        return choice;
    }
}
