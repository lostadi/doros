<div align="center">

# Doros

### A living wallpaper by Lee Daghlar Ostadi

Dots that bond, keep rhythm, fuse and divide, and whose rules evolve.

[Build it yourself](docs/BUILDING.md) · [The equations](docs/DYNAMICS.md) · [Privacy](docs/PRIVACY.md)

</div>

Doros turns an Android home screen into a small world that is never drawn,
only grown. Nothing in it is a prescribed shape. Every glowing dot obeys the
same few equations:
- **Bonds:** a dot bonds to nearby dots up to its valence, more readily when they share its rhythm and colour.
- **Springs:** a bond is a spring that breathes with that rhythm and snaps when stretched or out of step.
- **Sharing:** rhythm, colour, spin and depth spread along bonds.
- **Motion:** each dot gathers toward dots in step with it, circles the density it feels, swims, and drifts in the current of a hidden Game of Life world.

Bodies grow out of those rules on their own, with crystal cores, lacy rims and spiral arms. So do synchrony, fusion and division. Every line you see is a bond between two dots.

The rules are not fixed either. Each dot carries part of its own rulebook as
genes: how long its bonds like to be, how strongly it breathes, how hard it
swims. Genes spread along bonds, are remembered and passed on when bodies fuse
and divide, drift with each lineage, and lean toward whatever the hidden world
favours where the dot swims. As the system evolves, so do the rules that
drive it.

<p align="center"><img src="docs/images/doros.jpg" width="300" alt="A Doros frame: glowing lattice bodies of bonded dots with spiral arms spread over a dark screen; three bodies fusing in the middle blend from orange through green to magenta and cyan"></p>

*An offscreen Android render at full phone resolution (1280 × 2856), 90 seconds after a random start. Not a photograph of a phone.*

The name puts a **D**, for *dynamic*, in front of *-oros*, from *kairos*: the right moment.

## What you see

- **Bodies that make themselves.** Each lineage starts as a loose random cloud. Its dots knit into a lattice within seconds. Dots that can hold more bonds sort into the centre and become crystal cores, while dots that hold two or three make nets and lacy rims. Swirl strongest at the edge winds them into spiral arms.
- **Fusion and division without a script.** Bodies that fall into step attract and knit together, and colour and rhythm blend along the new bonds. When their rhythms can no longer stay locked they drift apart again. Quorum sensing loosens any body that grows too large, and shed fragments drift back to the nearest crowd.
- **Rules that evolve.** Bond length, breathing and swimming are genes. They change with each body's history and surroundings, so shapes and pulses keep shifting long after the start.
- **The whole screen.** Bodies spread over all of it and start in a new random arrangement every time.
- **Depth.** Near bodies are larger and brighter. Each body is drawn as a slowly rocking, tilted dome, and home-page swipes shift near bodies farther than far ones.
- **Colour that flows.** A gradient runs across each body and drifts smoothly. The hidden water carries colour from one body to another.
- **A companion.** Tap the wallpaper and nearby dots come to look, more eagerly the more you play. Come back after a while and they gather to meet you. They are calmer at night and sleepy on a low battery. With **Know my day**, the colours of the apps you spent time in arrive in the water when you return. That is read on the phone only; Doros has no internet permission.

## Controls

- **Drift** sets the pace. Physics runs in fixed steps of simulated time, so its work follows Drift rather than the display rate.
- **Shape evolution** sets how fast lattices rebuild and rules wander.
- **Color drift** moves the palette.
- **Lineages** (1 to 9, about 270 dots each), **Merging**, **Collisions** and **Let crowding vary** shape the population.
- **Pattern influence** sets how strongly the hidden Life current carries the dots. **1 Hz** or **4 Hz** sets the pace of Life generations.

Defaults are calm: Drift 0.11×, Shape evolution 0.10×, Color drift 0.41×,
seven lineages, 1 Hz.

## Battery

Doros pauses whenever it is hidden. It draws at 60 fps only while you touch the
screen, then 24 fps (20 in Battery Saver or on a low battery). Between drawn
frames it sleeps instead of waking for every display refresh. On the author's
phone, offscreen renders spend about 1.4 ms of simulation and 0.9 ms of
geometry per drawn frame on average.

## Build and verify

Doros is Java with Android framework APIs and Python standard-library build
tools: no Gradle, Maven or third-party runtime dependencies.

```sh
python3 tools/test.py                       # eight simulation test suites
python3 tools/build.py --out dist           # unsigned APK
python3 tools/verify_reproducible.py        # tests + two clean builds, byte-compared
```

See [docs/BUILDING.md](docs/BUILDING.md) for the toolchain and signing. The
simulation suites check, among other things, that:
- **Lattice bookkeeping:** every bond is recorded exactly.
- **Motion:** stays finite, on screen and calm.
- **Emergence:** the lattice builds itself, and bodies keep fusing and dividing.
- **No collapse:** no body takes over the pond, and loose dust stays rare.
- **Evolving rules:** genes keep changing and stay within bounds.
- **Allocation:** a simulation step allocates nothing.

`tools/DorosProbe.java` renders real Android frames on a device and measures screen coverage, events, bond lengths, tap response and cost.

## License

Copyright (C) 2026 Lee Daghlar Ostadi.

Doros is free software: you can redistribute it and/or modify it under the
terms of the GNU General Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your option) any later
version. It is distributed without any warranty. See [LICENSE](LICENSE).
