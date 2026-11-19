package net.n0vanox.abyssalextent.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;
import net.n0vanox.abyssalextent.AbyssalExtent;
import net.n0vanox.abyssalextent.sound.ModSounds;

public class ModJukeboxSongs {
    //public static final ResourceKey<JukeboxSong> HORIZON_KEY = ResourceKey.create(Registries.JUKEBOX_SONG, AbyssalExtent.id("horizon"));

    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        //register(context, HORIZON_KEY, ModSounds.HORIZON, 159, 6);
    }

    private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key,
                                 Holder.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
    context.register(key, new JukeboxSong(soundEvent,
            Component.translatable(Util.makeDescriptionId("jukebox_song", key.identifier())), lengthInSeconds, comparatorOutput));
    }
}
