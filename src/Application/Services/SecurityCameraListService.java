package Application.Services;

import Application.*;
import Application.Enums.*;
import Builders.SecurityCameraBuilder;
import Devices.SecurityCamera;
import Enums.*;

import java.util.List;
import java.util.Scanner;

public class SecurityCameraListService extends Service
{

    public SecurityCameraListService(Application application) {
        super(application);
    }

    @Override
    public void Open(Scanner scanner) {
        while(true)
        {
            CameraListOption cameraListOption = displaySecurityCameraListOptions(scanner);

            handleMusicSystemOption(cameraListOption , scanner);
        }
    }

    private CameraListOption displaySecurityCameraListOptions(Scanner scanner)
    {
        System.out.println("\n=== Главное меню Управления Камерами ===");
        System.out.println("1. Добавить новую камеру");
        System.out.println("2. Удалить камеру по Id");
        System.out.println("3. Показать все камеры");
        System.out.println("4. Запустить все камеры");
        System.out.println("5. Выключить все камеры");
        System.out.println("6. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 6);
        return CameraListOption.fromValue(choice);
    }

    private void handleMusicSystemOption(CameraListOption cameraListOption , Scanner scanner)
    {
        switch(cameraListOption)
        {
            case ADD_NEW_CAMERA -> getApplication().getDeviceFactory().addNewCamera(onAddNewCamera());
            case REMOVE_CAMERA -> getApplication().getDeviceFactory().removeCameraById(onRemoveCamera(scanner));
            case GET_CAMERA_LIST -> showSecurityCameraList();
            case OPERATE -> getApplication().getDeviceFactory().getCameras().forEach(camera -> {
                System.out.println(camera.operate());
            });
            case TURN_OFF -> getApplication().getDeviceFactory().getCameras().forEach(camera -> {
                System.out.println(camera.turnOf());
            });
            case EXIT -> getApplication().Run();
        }
    }

    private SecurityCamera onAddNewCamera()
    {
        SecurityCameraBuilder securityCameraBuilder = new SecurityCameraBuilder();
        SecurityCamera securityCamera = securityCameraBuilder.build();
        System.out.println("New Camera #" + securityCamera.getId() + " created.");
        return securityCamera;
    }

    private int onRemoveCamera(Scanner scanner)
    {
        showSecurityCameraList();

        System.out.print("Введите ID камеры которую хотите убрать:");
        return InputValidator.getIntInput(scanner, 1, SecurityCamera.getMaxId());
    }

    private void showSecurityCameraList()
    {
        int i = 1;
        for(SecurityCamera securityCamera : getApplication().getDeviceFactory().getCameras())
        {
            System.out.println(i + ".Camera #" + securityCamera.getId());
            i++;
        }
    }
}
