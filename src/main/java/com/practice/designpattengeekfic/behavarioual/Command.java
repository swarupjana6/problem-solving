package com.practice.designpattengeekfic.behavarioual;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Command {

    public static void main(String[] args) {
        new Command().call();
    }

    private void call() {
        Room livingRoom = new LivingRoom();
        livingRoom.setCommand(new SwitchLightsCommand(new Light()));
        livingRoom.executeCommand();
    }
}

class House {

    private List<Room> rooms;

    public House() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}

@Data
class Light {
    private boolean switchOn;

    public void switchLights() {
        switchOn = !switchOn;
    }
}

interface HouseCommand {
    void execute();
}

@AllArgsConstructor
class SwitchLightsCommand implements HouseCommand {
    private Light light;

    @Override
    public void execute() {
        light.switchLights();
    }
}

class Room {
    @Setter
    HouseCommand command;

    public void executeCommand() {
        command.execute();
    }
}

class Kitchen extends Room {
}

class Bathroom extends Room {
}

class LivingRoom extends Room {
}

class Bedroom extends Room {
}
