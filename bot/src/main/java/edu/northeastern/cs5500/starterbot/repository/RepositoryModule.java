package edu.northeastern.cs5500.starterbot.repository;

import dagger.Module;
import dagger.Provides;
import edu.northeastern.cs5500.starterbot.model.Restaurant;

@Module
public class RepositoryModule {

    @Provides
    public GenericRepository<Restaurant> provideRestaurantsRepository(
            MongoDBRepository<Restaurant> repository) {
        return repository;
    }

    @Provides
    public Class<Restaurant> provideRestaurantPreference() {
        return Restaurant.class;
    }
}
