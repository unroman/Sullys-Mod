package com.uraneptus.sullysmod.core.registry;

import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import com.uraneptus.sullysmod.SullysMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SullysMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMSounds {
    public static final SoundSubRegistryHelper HELPER = SullysMod.REGISTRY_HELPER.getSoundSubHelper();

    //Music Discs
    public static final RegistryObject<SoundEvent> MUSIC_DISC_SCOUR = HELPER.createSoundEvent("music_disc.scour");

    //Item Sounds
    public static final RegistryObject<SoundEvent> POLISH_JADE = HELPER.createSoundEvent("block.grindstone.polish_jade");

    //Block Sounds
    public static final RegistryObject<SoundEvent> JADE_RICOCHET = HELPER.createSoundEvent("block.jade.ricochet");
    public static final RegistryObject<SoundEvent> FLINGER_FLINGS = HELPER.createSoundEvent("block.flinger_totem.shoot");

    //Entity Sounds
    public static final RegistryObject<SoundEvent> TORTOISE_HURT = HELPER.createSoundEvent("entity.tortoise.hurt");
    public static final RegistryObject<SoundEvent> BABY_TORTOISE_HURT = HELPER.createSoundEvent("entity.tortoise.hurt_baby");
    public static final RegistryObject<SoundEvent> TORTOISE_DEATH = HELPER.createSoundEvent("entity.tortoise.death");
    public static final RegistryObject<SoundEvent> BABY_TORTOISE_DEATH = HELPER.createSoundEvent("entity.tortoise.death_baby");
    public static final RegistryObject<SoundEvent> TORTOISE_AMBIENT = HELPER.createSoundEvent("entity.tortoise.ambient");
    public static final RegistryObject<SoundEvent> TORTOISE_HIDE = HELPER.createSoundEvent("entity.tortoise.hide");
    public static final RegistryObject<SoundEvent> TORTOISE_EMERGE = HELPER.createSoundEvent("entity.tortoise.emerge");
    public static final RegistryObject<SoundEvent> TORTOISE_HURT_HIDDEN = HELPER.createSoundEvent("entity.tortoise.hurt.hidden");
    public static final RegistryObject<SoundEvent> TORTOISE_LAY_EGG = HELPER.createSoundEvent("entity.tortoise.lay_egg");
    public static final RegistryObject<SoundEvent> TORTOISE_EGG_BREAK = HELPER.createSoundEvent("entity.tortoise.egg_break");
    public static final RegistryObject<SoundEvent> TORTOISE_EGG_CRACK = HELPER.createSoundEvent("entity.tortoise.egg_crack");
    public static final RegistryObject<SoundEvent> TORTOISE_EGG_HATCH = HELPER.createSoundEvent("entity.tortoise.egg_hatch");

    public static final RegistryObject<SoundEvent> TORTOISE_SHELL_PLACE = HELPER.createSoundEvent("entity.tortoise_shell.place");

    public static final RegistryObject<SoundEvent> LANTERNFISH_FLOP = HELPER.createSoundEvent("entity.lanternfish.flop");
    public static final RegistryObject<SoundEvent> LANTERNFISH_HURT = HELPER.createSoundEvent("entity.lanternfish.hurt");
    public static final RegistryObject<SoundEvent> LANTERNFISH_DEATH = HELPER.createSoundEvent("entity.lanternfish.death");
}
