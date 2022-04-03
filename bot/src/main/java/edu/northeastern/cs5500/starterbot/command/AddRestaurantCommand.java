package edu.northeastern.cs5500.starterbot.command;

import edu.northeastern.cs5500.starterbot.model.Restaurant;
import edu.northeastern.cs5500.starterbot.repository.GenericRepository;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

@Singleton
@Slf4j
public class AddRestaurantCommand implements Command {

    @Inject GenericRepository<Restaurant> restaurantRepository;

    @Inject
    public AddRestaurantCommand() {}

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public CommandData getCommandData() {
        return new CommandData(getName(), "Ask the bot to reply with all the restaurant")
                .addOptions(
                        new OptionData(
                                        OptionType.STRING,
                                        "restaurantId",
                                        "The bot will reply all restaurant with the provided text")
                                .setRequired(true),
                        new OptionData(
                                        OptionType.STRING,
                                        "image",
                                        "The bot will reply all restaurant with the provided text")
                                .setRequired(true),
                        new OptionData(
                                        OptionType.STRING,
                                        "description",
                                        "The bot will reply all restaurant with the provided text")
                                .setRequired(true),
                        new OptionData(
                                        OptionType.STRING,
                                        "openTime",
                                        "The bot will reply all restaurant with the provided text")
                                .setRequired(true),
                        new OptionData(
                                        OptionType.STRING,
                                        "type",
                                        "The bot will reply all restaurant with the provided text")
                                .setRequired(true),
                        new OptionData(
                                        OptionType.STRING,
                                        "address",
                                        "The bot will reply all restaurant with the provided text")
                                .setRequired(true),
                        new OptionData(
                                        OptionType.STRING,
                                        "restaurantPhone",
                                        "The bot will reply all restaurant with the provided text")
                                .setRequired(true),
                        new OptionData(
                                        OptionType.STRING,
                                        "orderId",
                                        "The bot will reply all restaurant with the provided text")
                                .setRequired(true));
    }

    @Override
    public void onEvent(CommandInteraction event) {
        log.info("event: /add");
        String discordUserId = event.getUser().getId();
        String restaurantId = event.getOption("restaurantId").getAsString();
        String image = event.getOption("image").getAsString();
        String description = event.getOption("description").getAsString();
        String openTime = event.getOption("openTime").getAsString();
        String type = event.getOption("type").getAsString();
        String address = event.getOption("address").getAsString();
        String restaurantPhone = event.getOption("restaurantPhone").getAsString();
        String orderId = event.getOption("orderId").getAsString();

        // add restaurant
        Collection<Restaurant> restaurants = restaurantRepository.getAll();

        Restaurant restaurant = null;

        // avoid add same restaurant
        for (Restaurant cur : restaurants) {
            if (cur.getRestaurantId().equals(restaurantId)) {
                restaurant = cur;
                break;
            }
        }

        if (restaurant == null) {
            restaurant = new Restaurant();
            restaurant.setRestaurantId(restaurantId);
            restaurant.setImage(image);
            restaurant.setDescription(description);
            restaurant.setOpenTime(openTime);
            restaurant.setType(type);
            restaurant.setAddress(address);
            restaurant.setRestaurantPhone(restaurantPhone);
            restaurant.setOrderId(orderId);
            restaurantRepository.add(restaurant);
        } else {
            restaurant.setImage(image);
            restaurant.setDescription(description);
            restaurant.setOpenTime(openTime);
            restaurant.setType(type);
            restaurant.setAddress(address);
            restaurant.setRestaurantPhone(restaurantPhone);
            restaurant.setOrderId(orderId);
            restaurantRepository.update(restaurant);
        }

        // submit task
        event.reply("Your restaurant " + restaurantId + " has store in our data set").queue();
    }
}
