package edu.northeastern.cs5500.starterbot.command;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

@Singleton
@Slf4j
public class HelpCommand implements Command {

    @Inject
    public HelpCommand() {}

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public CommandData getCommandData() {
        return new CommandData(getName(), "Ask the bot to reply with the provided text")
                .addOptions(
                        new OptionData(
                                        OptionType.STRING,
                                        "content",
                                        "The bot will help reply all command of this bot")
                                .setRequired(true));
    }

    @Override
    public void onEvent(CommandInteraction event) {
        log.info("event: /help");
        StringBuilder sb=new StringBuilder();
        sb.append("command1: order");
        sb.append("/n");
        sb.append("command2: history");
        sb.append("/n");
        sb.append("command2: allRestaurant");
        sb.append("/n");

        event.reply(sb.toString()).queue();
    }
}
