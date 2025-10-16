package Application.Services;

import Application.Application;

import java.util.Scanner;

public abstract class Service
{
    private final Application application;

    public Service(Application application)
    {
        this.application = application;
    }

    public Application getApplication()
    {
        return application;
    }

    public abstract void Open(Scanner scanner);
}
