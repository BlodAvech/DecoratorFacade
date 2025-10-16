package Application.Services;

import Application.*;
import Application.Enums.*;
import Enums.*;
import Factories.*;

import java.util.Scanner;

public class MusicSystemService extends Service
{

    public MusicSystemService(Application application)
    {
        super(application);
    }

    @Override
    public void Open(Scanner scanner)
    {
        while(true)
        {
            MusicSystemOption musicSystemOption = displayMusicSystemOptions(scanner);

            handleMusicSystemOption(musicSystemOption , scanner);
        }
    }
    public MusicSystemOption displayMusicSystemOptions(Scanner scanner)
    {
        System.out.println("\n=== Главное меню Управления Музыкой ===");
        System.out.println("1. Запустить");
        System.out.println("2. Установить Громкость");
        System.out.println("3. Выбрать Музыку");
        System.out.println("4. Сбросить Музыку");
        System.out.println("5. Приостановить Музыку");
        System.out.println("6. Показать текущую музыку");
        System.out.println("7. Выключить");
        System.out.println("8. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 8);
        return MusicSystemOption.fromValue(choice);
    }

    public void handleMusicSystemOption(MusicSystemOption musicSystemOption , Scanner scanner)
    {
        switch(musicSystemOption)
        {
            case OPERATE -> System.out.println(getApplication().getDeviceFactory().getMusicSystem().operate());
            case SET_VOLUME -> getApplication().getDeviceFactory().getMusicSystem().setVolume(onSetValue(scanner));
            case SET_MUSIC -> getApplication().getDeviceFactory().getMusicSystem().setMusic(onSetMusic(scanner));
            case RESET_MUSIC ->  getApplication().getDeviceFactory().getMusicSystem().resetMusic();
            case STOP_PLAYING ->   getApplication().getDeviceFactory().getMusicSystem().stopPlaying();
            case GET_CURRENT_MUSIC ->  System.out.println("Current Music is: " + getApplication().getDeviceFactory().getMusicSystem().getCurrentMusic());
            case TURN_OFF -> System.out.println(getApplication().getDeviceFactory().getMusicSystem().turnOf());
            case EXIT -> getApplication().Run();
        }
    }

    public MusicVolume onSetValue(Scanner scanner)
    {
        System.out.println("\n=== Выберите Громкость ===");
        System.out.println("1. Максимальный");
        System.out.println("2. Обычный");
        System.out.println("3. Тихий");
        System.out.println("4. Беззвучный");
        System.out.println("5. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 5);

        if(choice == 5) Open(scanner);
        return MusicVolume.fromValue(choice);
    }
    public String onSetMusic(Scanner scanner)
    {
            System.out.println("\n=== Выберите Музыку ===");
            String choice = InputValidator.getStringInput(scanner , "Введите название музыки(e to exit):");

            if(choice.equals("e"))
            {
                Open(scanner);
            }
            return choice;

    }
}
