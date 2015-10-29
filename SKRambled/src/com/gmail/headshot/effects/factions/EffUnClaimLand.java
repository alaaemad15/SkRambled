package com.gmail.headshot.effects.factions;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.event.Event;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.massivecore.ps.PS;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffUnClaimLand extends Effect {

	private Expression<Location> location;

	@Override
	protected void execute(Event event) {

		Location location = this.location.getSingle(event);

		if (location == null) {
			return;
		}
		Chunk chunk = location.getWorld().getChunkAt(location);
		BoardColl.get().setFactionAt(PS.valueOf(chunk),
				FactionColl.get().getByName("Wilderness"));
	}

	@Override
	public String toString(Event event, boolean b) {
		return "faction unclaim location";
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean,
			SkriptParser.ParseResult parseResult) {
		this.location = (Expression<Location>) expressions[0];
		return true;
	}

}
