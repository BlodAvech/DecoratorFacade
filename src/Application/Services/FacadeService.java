package Application.Services;

import Application.*;
import Application.Enums.FacadeOption;
import Application.Enums.LightOption;

import java.util.Optional;
import java.util.Scanner;

public class FacadeService extends Service
{

    public FacadeService(Application application) {
        super(application);
    }

    @Override
    public void Open(Scanner scanner) {
        FacadeOption facadeOption = getFacadeOption(scanner);

        handleFacadeOption(facadeOption);
    }

    private FacadeOption getFacadeOption(Scanner scanner)
    {
        System.out.println("\n=== Меню Управления Дома ===");
        System.out.println("1. Включить Все");
        System.out.println("2. Режим Вечеринки");
        System.out.println("3. Ночной Режим");
        System.out.println("4. Выключить Все");
        System.out.println("5. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 5);
        return FacadeOption.fromValue(choice);
    }

    private void handleFacadeOption(FacadeOption facadeOption)
    {
        switch (facadeOption)
        {
            case ON_MODE -> getApplication().getDeviceStorage().getFacade().cameHome();
            case OFF_MODE -> getApplication().getDeviceStorage().getFacade().leaveHome();
            case PARTY_MODE ->  getApplication().getDeviceStorage().getFacade().partyMode();
            case NIGHT_MODE ->   getApplication().getDeviceStorage().getFacade().nightMode();
            case EXIT -> getApplication().Run();
        }
    }
}
