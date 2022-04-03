package edu.northeastern.cs5500.starterbot.command;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module
public class CommandModule {

    @Provides
    @IntoSet
    public Command provideSayCommand(SayCommand sayCommand) {
        return sayCommand;
    }

    @Provides
    @IntoSet
<<<<<<< HEAD
    public Command provideHelloCommand(HelloCommand helloCommand) {
        return helloCommand;
    }

    @Provides
    @IntoSet
    public Command provideAddRestaurantCommand(AddRestaurantCommand addRestaurantCommand) {
        return addRestaurantCommand;
    }

    @Provides
    @IntoSet
    public Command provideShowRestaurantCommand(ShowRestaurantCommand showRestaurantCommand) {
        return showRestaurantCommand;
=======
    public Command provideHelpCommand(HelpCommand helpCommand) {
        return helpCommand;
>>>>>>> 9d7f3cec535516acb438249aaaa80b17994f2f07
    }
}
