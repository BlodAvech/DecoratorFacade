package Application.Services;

import Application.*;
import Application.Enums.DecoratorsOption;
import Application.Enums.LightListOption;
import Devices.Device;
import Enums.Decorators;
import Enums.RemoteCommand;
import Enums.VoiceCommand;

import java.util.Scanner;

public class DecoratorsService extends Service
{
    private Device currentDevice;
    private Service currentDeviceService;

    public DecoratorsService(Application application) {
        super(application);
    }

    @Override
    public void Open(Scanner scanner) {
        DecoratorsOption option = showDecoratorsOption(scanner);
        handleDecoratorsOption(option, scanner);
    }

    public void Open(Scanner scanner,Device device , Service service)
    {
        this.currentDevice = device;
        this.currentDeviceService = service;

        DecoratorsOption option = showDecoratorsOption(scanner);
        handleDecoratorsOption(option, scanner);
    }

    public DecoratorsOption showDecoratorsOption(Scanner scanner) {
        System.out.println("\n=== Выберите Декоратор ===");
        System.out.println("1. Экономия Энергии");
        System.out.println("2. Удаленный Доступ");
        System.out.println("3. Голосовой Контроль");
        System.out.println("4. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 4);
        return DecoratorsOption.fromValue(choice);
    }

    private void handleDecoratorsOption(DecoratorsOption option , Scanner scanner)
    {
        switch (option)
        {
            case ENERGY_SAVE ->  getApplication().getDeviceStorage().wrapDevice(currentDevice , Decorators.ENERGY_SAVE).getEnergyUse();
            case REMOTE_ACCESS -> getApplication().getDeviceStorage().wrapDevice(currentDevice , Decorators.REMOTE_ACCESS).remoteAccess(onRemoteAccess(scanner));
            case VOICE_CONTROL -> getApplication().getDeviceStorage().wrapDevice(currentDevice , Decorators.VOICE_CONTROL).voiceCommand(onVoiceCommand(scanner));
            case EXIT -> currentDeviceService.Open(scanner);
        }
    }

    private RemoteCommand onRemoteAccess(Scanner  scanner)
    {
        System.out.println("\n=== Выберите Команду Удаленного Доступа ===");
        System.out.println("1. Запустить Удаленно");
        System.out.println("2. Отключить");
        System.out.println("3. Отмена");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 3);
        if(choice == 3) Open(scanner);

        return RemoteCommand.fromValue(choice);
    }

    private VoiceCommand onVoiceCommand(Scanner  scanner)
    {
        System.out.println("\n=== Пункт Голосовово Ввода ===");

        String choice = InputValidator.getStringInput(scanner, "Говорите: ").toLowerCase();
        if(choice.equals("exit")) Open(scanner);
        return VoiceCommand.fromValue(choice);
    }
}
