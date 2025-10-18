package Application;

import Application.Enums.FacadeOption;
import Application.Enums.MenuOption;
import Application.Services.*;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;
import Storages.DeviceStorage;


public class Application
{
    private final DeviceStorage deviceStorage = new DeviceStorage();

    //Application.Services
    private final MenuService menuService = new MenuService();
    private final MusicSystemService musicSystemService = new MusicSystemService(this);
    private final ThermostatService thermostatService = new ThermostatService(this);
    private final SecurityCameraListService securityCameraListService = new SecurityCameraListService(this);
    private final LightListService lightListService = new LightListService(this);
    private final LightService lightService = new LightService(this);
    private final FacadeService facadeService = new FacadeService(this);

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

            handleMenuOption(menuOption);
        }
    }

    public void handleMenuOption(MenuOption menuOption)
    {
        switch (menuOption)
        {
              case LIGHTS_LIST -> lightListService.Open(scanner);
              case MUSIC_SYSTEM -> musicSystemService.Open(scanner);
              case THERMOSTAT -> thermostatService.Open(scanner);
              case SECURITY_CAMERAS -> securityCameraListService.Open(scanner);
              case FACADE -> facadeService.Open(scanner);
              case EXIT -> System.exit(0);
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

    public DeviceStorage getDeviceStorage() {
        return deviceStorage;
    }

    public LightListService getLightListService() {return lightListService;}
    public LightService getLightService() {return lightService;}
}
