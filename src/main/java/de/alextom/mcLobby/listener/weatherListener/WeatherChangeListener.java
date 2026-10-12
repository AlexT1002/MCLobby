package de.alextom.mcLobby.listener.weatherListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeListener implements Listener {
    @EventHandler
    public void weatherChange(WeatherChangeEvent event){
        event.setCancelled(true);
    }
}
