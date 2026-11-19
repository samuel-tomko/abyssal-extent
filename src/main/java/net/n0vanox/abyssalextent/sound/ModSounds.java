package net.n0vanox.abyssalextent.sound;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.n0vanox.abyssalextent.AbyssalExtent;

public class ModSounds {

    //public static final Holder.Reference<SoundEvent> HORIZON = registerJukeboxSong("horizon");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = AbyssalExtent.id(name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    private static Holder.Reference<SoundEvent> registerJukeboxSong(String name) {
        Identifier id = AbyssalExtent.id(name);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSounds() {
        AbyssalExtent.LOGGER.info("Registering sounds for " + AbyssalExtent.MOD_ID);
    }
}
