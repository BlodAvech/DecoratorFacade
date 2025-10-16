package Application;

import Application.Enums.MenuOption;
import Application.Services.MenuService;
import Application.Services.MusicSystemService;
import Application.Services.SecurityCameraListService;
import Application.Services.ThermostatService;
import Factories.DeviceFactory;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;


public class Application
{
    //Factory
    private final DeviceFactory deviceFactory = new DeviceFactory();

    //Application.Services
    private final MenuService menuService = new MenuService();
    private final MusicSystemService musicSystemService = new MusicSystemService(this);
    private final ThermostatService thermostatService = new ThermostatService(this);
    private final SecurityCameraListService securityCameraListService = new SecurityCameraListService(this);

    private Scanner scanner;

    public Application()
    {

        setupConsoleEncoding();
        initializeScanner();
    }
    public void Run()
    {
        while(true)
        {
            MenuOption menuOption = menuService.displayMainMenu(scanner);

            if(menuOption == MenuOption.EXIT) break;

            handleMenuOption(menuOption);
        }
    }

    public void handleMenuOption(MenuOption menuOption)
    {
        switch (menuOption)
        {
//            case LIGHTS_LIST -> ;
              case MUSIC_SYSTEM -> musicSystemService.Open(scanner);
              case THERMOSTAT -> thermostatService.Open(scanner);
              case SECURITY_CAMERAS -> securityCameraListService.Open(scanner);
//            case FACADE -> ;
        }
    }

    private void initializeScanner() {
        this.scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        this.scanner.useLocale(Locale.forLanguageTag("ru-RU"));
    }

    private void setupConsoleEncoding() {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new java.io.PrintStream(System.err, true, StandardCharsets.UTF_8));
        Locale.setDefault(new Locale("ru", "RU"));
    }

    public DeviceFactory getDeviceFactory() {
        return deviceFactory;
    }
}
