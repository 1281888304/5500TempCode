package edu.northeastern.cs5500.starterbot.command;

import edu.northeastern.cs5500.starterbot.model.Restaurant;
import edu.northeastern.cs5500.starterbot.repository.GenericRepository;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.bson.types.ObjectId;

@Singleton
@Slf4j
public class ShowRestaurantCommand implements Command {

    @Inject GenericRepository<Restaurant> restaurantRepository;

    @Inject
    public ShowRestaurantCommand() {}

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "show";
    }

    @Override
    public CommandData getCommandData() {
        // TODO Auto-generated method stub

        return new CommandData(getName(), "Ask the bot to reply with all the restaurant")
                .addOptions(
                        new OptionData(
                                        OptionType.STRING,
                                        "content",
                                        "The bot will reply all restaurant with the provided text")
                                .setRequired(true));
    }

    @Override
    public void onEvent(CommandInteraction event) {
        log.info("event: /show");
        String type = event.getOption("content").getAsString();
        Collection<Restaurant> restaurants = new ArrayList<>(); // size=0
        //        if (type.equals("all")) {
        //            restaurants = restaruantRepository.getAll();
        //        }
         restaurants = restaurantRepository.getAll();
        //Restaurant r1 = restaurantRepository.get(new ObjectId("6241d04dc31157f76a3c6529"));
        event.reply("now we have " + restaurants.size() + " restaurants.").queue();
    }
}
