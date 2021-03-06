package edu.northeastern.cs5500.starterbot.command;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

@Singleton
@Slf4j
public class HelloCommand implements Command {

    @Inject
    public HelloCommand() {}

    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public CommandData getCommandData() {
        return new CommandData(getName(), "hello")
                .addOptions(
                        new OptionData(
                                        OptionType.STRING,
                                        "content",
                                        "The bot will reply to your command with the provided text")
                                .setRequired(true));
    }

    @Override
    public void onEvent(CommandInteraction event) {
        log.info("event: /hello");
        event.reply(event.getOption("content").getAsString()).queue();
    }
}
