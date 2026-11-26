# How Doros evolves

Doros reduces a living pond to the equations each dot obeys. Nothing above the dot is scripted: bodies, their shapes, synchrony, fusion and division come out of those equations. A dot's colour is its kind, and colours flow, so the rules that drive each dot keep changing as the system evolves.

## What a dot is

Each dot *i* has a position in four dimensions (two on the screen and two hidden, see [Hidden dimensions](#hidden-dimensions)) and a velocity. It also has:
- a rhythm θᵢ and a hue *h*ᵢ;
- a heat *r*ᵢ between 0 and 1;
- a spin *s*ᵢ and a swimming heading ψᵢ;
- a depth *d*ᵢ;
- a valence *V*ᵢ, 2 to 6: the most bonds it can hold.

It belongs to a lineage, the group it was born in. The lineage fixes its natural rhythm and what its colour, spin and depth lean back toward. Lengths are in units of the screen's shorter side: the lattice spacing *a* = 0.025, about 32 px on a 1280-px-wide screen. Time is in pond seconds, which run at Drift × 1.5 real seconds.

## Colour is kind

A dot's colour sets its properties, the way an element's place in the table sets an atom's. With *H* the colour as drawn (the hue plus 214°), each property peaks at its own colour:

| Property | Rule | Peaks at |
|---|---|---|
| Bond length | × (1 + 0.085 cos(*H* − 45°)) | orange-yellow: open, airy lattices |
| Breathing | 0.14 + 0.09 cos(*H* − 120°) | green |
| Valence | lineage valence + round(0.9 cos(*H* − 200°)), 2 to 6 | cyan-blue: an extra bond, so crystals; a dot that loses valence lets its longest bonds go |
| Swimming | × (1 + 0.37 cos(*H* − 290°)) | violet |
| Mass | (1 + 0.615 cos(*H* − 220°)) · (1 + 0.12 (*k* − 2)) · (1 − 0.45 *r*), 0.35 to 3, for *k* bonds | blue is heavy, bonds add mass, heat makes a vertex light |

Mass divides every force on a dot, its own drive included.

Colour flows, and the properties flow with it:
- **Relaxes:** toward the dot's remembered colour at 1/16 per pond second. The target is shifted by the hidden Life pattern under the dot (±70°) and by how deep inside a body it sits (±35°), which paints gradients across bodies.
- **Diffuses** along bonds at 0.1.
- **Drifts** with **Color drift**: faster when the Life world is busy. The rate itself eases over 20 seconds, so colours shift steadily.
- **Remembers:** the memory learns what the dot became (time constant 120 pond seconds, not while it is hot) and leans back toward its lineage's own colour (90 pond seconds). Each lineage's colour drifts at its own rate, 0.7 to 1.3 times the drift. Lineages keep distinct colours through fusion and division, so a fused body shows its lineages as colour patches and gradients, and which colours meet keeps changing.

## Bonds: the propensity to make lattices

Two unbonded dots within reach (their exclusion distance plus 0.2*a*), each with a free valence, bond at rate

  *k*ₒₙ = 5 · *R* · ((1 + cos(θᵢ − θⱼ)) / 2)² · (0.3 + 0.7 · (1 + cos(*h*ᵢ − *h*ⱼ)) / 2) · (1 − *r*ᵢ*r*ⱼ)(1 + 0.195 |*r*ᵢ − *r*ⱼ|) · *Q*

so dots bond most readily when they are in step and alike in colour. Hot vertices hardly bond to each other but bond readily to cool ones. *R* is the rewiring rate set by **Shape evolution**, and *Q* = (1 − *c*ᵢ)(1 − *c*ⱼ) applies only between different lineages (see Quorum below). A bond is a damped spring whose rest length breathes with the two rhythms:

  *L* = *a* · ½(*g*ₛᵢ + *g*ₛⱼ) · (1 + ½(*g*ᵦᵢ + *g*ᵦⱼ) · (cos θᵢ + cos θⱼ) / 2),  **F** = *σ* [36 (*r* − *L*) + 2.5 (Δ**v** · **r̂**)] **r̂**

where *g*ₛ and *g*ᵦ are the bond length and breathing set by each dot's colour.

Its strength *σ* grows from 0 to 1 over 0.45 pond seconds, and fades out over 0.35 when it breaks. A bond snaps when stretched past 1.85*a*, and otherwise at hazard rate

  0.35 · *R* · [0.05 + ((1 − cos(θᵢ − θⱼ)) / 2)² + 0.6 *u*² + 2.5 *c̄* + 2 *r*ᵢ*r*ⱼ]

where *u* is the local restlessness of the Life world (the fraction of cells that changed nearby) and *c̄* the pair's mean quorum crowding. Bonds that meet at a dot repel in angle (energy 0.12 *a* cos φ for each pair), so a dot's bonds spread evenly: three open to 120°, four to 90°, six to 60°.

All dots repel inside 0.72*a*. Unbonded dots also keep an exclusion distance that depends on valence, from 1.0*a* for six bonds to 1.6*a* for two, so dots that hold few bonds make open lattices: chains, honeycomb nets, square nets. Between hot vertices it grows by a factor of 1 + 0.514 √(*r*ᵢ*r*ⱼ).

## Heat: crowded vertices glow red

A vertex's pressure is how crowded it is per bond it holds:

  ℓᵢ = *n*ᵢ / (1 + 0.5 *k*ᵢ),  *p*ᵢ = clamp((ℓᵢ − 3.6) / 1.5, 0, 1)

where *n*ᵢ counts the dots within 1.35*a* (bonded or not) and *k*ᵢ is its strength-weighted bond count. Heat follows pressure: it rises toward *p*ᵢ at 0.444 per pond second and cools toward it at 0.25.

In a well-knit lattice each neighbour is a bond, and a vertex stays cool. A crushed core heats, and so does a loose dot in a crowd. Heat is drawn as red and is a vertex's most repulsive state:
- **Repels:** hot vertices keep each other further apart.
- **Gathers less:** a fully hot vertex drifts outward.
- **Frays:** hot–hot bonds fray.
- **Links outward:** hot vertices bond to cool vertices on the outer shell.
- **Lightens:** heat makes a vertex light.

A crowded cluster therefore unfolds into new shapes and cools as it spreads.

## What travels along bonds

Weighted by bond strength and normalised by each dot's total bond weight:

- **Rhythm** (Kuramoto coupling): θ̇ᵢ = ω*ₗ* εᵢ *m* (1 + 0.095 (ρ̃ᵢ − 0.8)) + 2.53 *E*ʷᵢ ⟨sin(θⱼ − θᵢ)⟩ + 0.783 *E*ʷᵢ *K*ᵢ.
  - ω*ₗ*: the lineage's natural frequency.
  - εᵢ: a fixed ±2% per dot.
  - *m*: the mood.
  - ρ̃ᵢ: how deep in a body the dot sits. Deeper dots keep slightly faster time (a pacemaker), so cores lead and phase waves travel to the rim.
  - *K*ᵢ: the pull of the local mean rhythm in the near field.
  - *E*ʷᵢ: the exclusion factor at body scale (below).
- **Colour:** as above, diffusing at 0.1.
- **Spin and depth** diffuse the same way (rates 0.5 and 0.4) and relax toward the lineage's values over 30 and 25 pond seconds.
- **Heading:** ψ̇ᵢ = 2.0 ⟨sin(ψⱼ − ψᵢ)⟩, plus a slow random turn.

## A continuous exclusion principle

The dots are deposited on a coarse grid (cells of 0.0625) at their positions on the screen, and blurred at two scales: *near* (σ = 0.06, a few spacings) and *wide* (σ = 0.30). The near field is also weighted by cos θ and sin θ, so each dot can sense the density of dots *in step with it*, its same-state occupancy:

  *n*ᵢ = (ρ_cos cos θᵢ + ρ_sin sin θᵢ) / ρ_lattice,  *E*ᵢ = clamp(1 − (*n*ᵢ / 1.4)³, −1.5, 1)

ρ_lattice is the density of a relaxed lattice. The same law with the total near density gives *B*ᵢ for all dots, in step or not. Gathering is scaled by these factors, so the pull together fades as packing nears 1.4 times a relaxed lattice and turns into a push apart beyond it. Rhythm coupling follows the same law at body scale (the wide field, critical at 1.15), *E*ʷᵢ: a body in step stays in step, while an over-full same-state crowd falls out of step. Sensed at the dot's own scale, it loosened the tightest cores' rhythm: phase order within bodies fell from about 0.89 to 0.76. While *E*ᵢ < 0, a degeneracy pressure (0.02 |*E*ᵢ|) also pushes the dot down the body-scale gradient of dots in step with it. Many dots can share a place only by occupying different rhythms, and no body can crush itself.

## How a dot moves: swarmalator terms

The gathering follows the swarmalator model of O'Keeffe, Hong and Strogatz (2017), in which oscillators attract more strongly when their phases agree. Each dot relaxes (drag 6 per pond second, divided by its mass, implicitly integrated) toward the velocity

  **v**\* = κᵢ [0.0025 *B*ᵢ ∇ρₙₑₐᵣ + 0.00506 *E*ᵢ ∇(ρ_cos cos θᵢ + ρ_sin sin θᵢ)]  (gather, harder toward dots in step)
     + 0.0939 *s*ᵢ **ẑ** × ∇̂ρₙₑₐᵣ · min(1, |∇ρₙₑₐᵣ| / 2.5)  (swirl around the density it feels)
     + strokes (below)
     + 0.026 *g*ᵥᵢ (cos ψᵢ, sin ψᵢ)  (swim, scaled by its colour's swimming)
     + 0.02 **u**_Life  (the Life current)
     − 0.0072 · (1 − ς) · *climate* · ∇ρ_wide  (spread: bodies keep apart)
     + 0.0465 · ς · ∇̂ρ_wide  (a dot in sparse surroundings climbs toward the nearest crowd)

plus the bond, angle and spacing forces, the frame (below), a little thermal jitter that grows where Life is restless, and a person's touch or welcome.

- **κᵢ** = (0.4 + 0.6 *V*ᵢ / 6)(1 − 0.9 *c*ᵢ)(1 + 1.2 (1 − *k*ᵢ / *V*ᵢ))(1 − 1.08 *r*ᵢ). Dots that hold more bonds gather harder, so dense cores sort inward (differential adhesion). Crowded and hot dots gather less, and dots with unused valence seek company harder.
- **ς** = clamp(1 − ρ_near / 0.5, 0, 1) is how sparse a dot's own neighbourhood is, so shed fragments drift back to bodies instead of being pushed away.
- **Vary:** the climate factor breathes with the coupled chaotic drive.

**Strokes.** Each dot also moves to its own rhythm, relative to the density it feels:
- **In and out:** 0.0278 cos θᵢ along ∇̂ρₙₑₐᵣ.
- **Around:** 0.0033 *s*ᵢ sin θᵢ.
- **Circle:** a small circle along its heading, 0.0087 (cos(θᵢ + ψᵢ), sin(θᵢ + ψᵢ)).

In a body in step, every dot strokes together; where phases lag, the strokes travel through it as waves.

## Hidden dimensions

Each dot has two hidden coordinates.
- **Interactions:** bonds, spacing, bending and exclusion act in all four dimensions. Everything sensed at the scale of crowds acts on the dot's shadow on the screen and is lifted back into four dimensions along the directions the projection mixes: gathering, swirl, spread, the current, the frame, touch and strokes.
- **Room:** the hidden room opens over the first minute: a restoring pull beyond ±0.02, and a hard wall at ±0.05.
- **Projection:** what you see is the shadow:

    *x*_screen = *x* cos *A* + *z*₁ sin *A*,  *y*_screen = *y* cos *B* + *z*₂ sin *B*

  The angles swing slowly: *A* = 0.433 sin(2π*t*/61 + φ_A) and *B* = 0.433 sin(2π*t*/89 + φ_B). The arrangement turns past the screen, and forces between dots come and go.

## An open frame

The screen is a window onto a larger pond.
- **Edge zone:** within 0.14 of an edge, swimmers turn their heading back and are eased inward.
- **Shore:** beyond the edge, a pull back proportional to the distance *b* out, fading as (1 − *b*/0.18)² to nothing at the far side of a 0.18 margin. A dot carried that far has left.
- **Spill:** all of this holds fully while the pond is at its size (the chosen **Lineages** × 270 dots), weakens as it fills past it, and reverses beyond 5% over. An over-full pond overflows at its rim.
- **Arrivals:** groups arrive from beyond the edges, 0.06 per pond second until the pond is 4% over its size, plus 0.1 for each tenth it is short. So groups keep coming and going while the pond stays within a few percent of its size.

Each arriving group slides in through a random point of the edges, a row at a time, placed so that its shadow enters there. Every group differs:
- **Size:** 6 to 76 vertices.
- **Shape:** a thin stream (rows of one or two) or a broad band (three to eight across), entering as a triangular lattice.
- **Density:** 0.75 to 1.95 spacings apart.
- **Speed:** 0.03 to 0.12 per pond second, with an entry drive that fades over 12 pond seconds.
- **Colour:** its lineage's colour ± 40°, and with it its kind.
- **Depth and rhythm:** a random depth, and the lineage's rhythm and spin.

## Quorum

*c*ᵢ = clamp((ρ_wide(**x**ᵢ) − 0.90) / 0.5, 0, 1) is how crowded a dot feels at long range. A normal body's centre reads 0.55 to 0.75; a body several lineages large reads above 1. Crowded dots gather less, their bonds fray faster, and they stop bonding to other lineages, so no body keeps growing.

## Rhythms that wander

Each lineage's natural frequency (3.7 radians per pond second, ±12%) follows an Ornstein–Uhlenbeck walk with a time constant of 15 pond seconds divided by *R*. Which bodies can lock into one rhythm therefore keeps changing.

## What emerges

None of these is written anywhere in the code; they are what the equations do:

- **Shapes.** Open, lacy lattices that take on rings, loops, crescents, curled arms and webs. Crystal cores form where six-bond dots sort inward, and lacy chains at the rim.
- **Unfolding.** A cluster that packs too tight heats, glows red at its most crowded vertices, and unfolds: hot vertices push apart and link outward.
- **Synchrony.** Bodies stroke and pulse in one rhythm, with waves travelling from their cores where they are not quite locked.
- **Fusion and division.** Bodies that fall into step attract and bond. Rhythms that cannot stay locked drift out of step, out-of-step bonds fray, and attraction turns to repulsion; quorum also loosens bodies that grow too large.
- **Colour.** Gradients by depth and by the hidden pattern, and patches where lineages meet. Since colour sets kind, a body's texture shifts as its colours do.
- **Exchange.** Groups drift in, parts of bodies drift out over the edges, and fused bodies carry their lineages' colours into the bodies they divide into.

## What is set, not emergent

- **Lineages:** each lineage's recipe of valences (centre to rim), colour, spin, depth and natural rhythm.
- **Starting arrangement:** random on every start. Groups of random size land at random, well-spread places, as lumpy tilted clouds with part of each group still loose.
- **Arrivals:** the random size, shape, density, speed, colour and point of entry of each arriving group.
- **Drawing:** the depth layers and the tilted-dome projection that give the three-dimensional look are presentation, not dynamics.
- **Events:** fusions and divisions are only *observed*, for the flashes and the log. A fusion is counted when at least four grown bonds join two earlier bodies of 36 or more dots; a division when a body's dots end up in two groups of 36 or more.

## Drawing

- **Bonds:** every line is a bond and ends at two drawn dots. Lines are hairlines about a third of a dot's width. The Life world and the water are never drawn.
- **Exact colour:** each dot is drawn in its own colour, with no palette steps, and every bond is a gradient between its two dots' colours. Colour moves through bodies as a gradient instead of switching.
- **Heat:** heat is mixed in as a vivid red, as strongly as the vertex is hot, and hot vertices glow red. The kinds' own colours are slightly softer near pure red, so vivid red always means heat.
- **The beat:** a dot's size and brightness follow its nearness and its rhythm smoothly, so a body in step swells and brightens as one on every beat, and its dots glow near the top of it.
- **Depth:** each body is drawn as a domed disc tilted toward or away from you about a slowly turning axis. Nearer bodies are larger, and a dome's near side is larger and brighter. Dots are drawn far to near.
- **Parallax:** home-page swipes shift near dots farther than far ones.
- **No tearing:** the projection is a smooth field over the screen, blended from nearby bodies, so bonded neighbours always get nearly the same transform. A snapped bond is not drawn while it fades, and no bond is drawn longer than 2.6 spacings.
- **Steady state:** when the pond moves a dot to another slot, or a group arrives, the drawing state follows each dot, so nothing else twitches.
- **Edges:** dots are drawn up to a bond's length beyond the edge, so bonds run off the screen to real dots.
- **Flashes:** a soft glow marks each fusion and division, with no ring.

Dots, glows and bonds are drawn as three batches of textured quads, every vertex in its dot's colour.

## Cost

Physics advances in fixed steps of 0.025 pond seconds. Frames between steps draw positions interpolated between the last two states, so work follows Drift rather than the display rate: at Drift 0.11 that is about 6.6 steps a second, however many frames are drawn. Because bodies are no longer crushed, each dot has a handful of close neighbours instead of dozens, so a step costs well under half what it did when bodies collapsed into balls.

## Measured

Offscreen Android renders on the author's phone (seven lineages of about 270 dots, 1 Hz Life, Shape evolution 0.10, Colour drift 0.41), 300 pond seconds each, run at Drift 0.5 so a long run fits in a few minutes:

| | Now | Bodies collapsing (before the local exclusion) |
|---|---|---|
| Screen lit at any moment | 34% (every part lit at some point) | 7% |
| Physics step, 1,890 dots | about 3.4 ms | about 8.8 ms |
| Dots holding a bond | 99% | 97% |
| Colour spread within a body | about 35° | about 10° |

Other figures from the same renders:
- **Loose dots:** 5%.
- **Hot vertices** (heat over 0.3): about 2%.
- **Pond size:** 103% of its target on average.
- **Longest drawn bond:** 83 px at full resolution (rest 32 px); no frame with a bond over 3 spacings.
- **Fusions and divisions:** 140 to 190 each per 300 pond seconds, about 5 a minute at the default Drift.
- **Unison:** within bodies of 40 dots or more, the phase order parameter averages about 0.89 (headless, 160 pond seconds; 1 is perfect unison).

Headless runs of 400 pond seconds, with the same equations: the pond stayed within 103–104% of its size, ten groups arrived, about 190 dots left over the edges, and 1,000 to 2,000 dots crossed the screen's edge each way per pond minute.

Fusions and divisions are only *observed*. A fusion is counted when at least four grown bonds join two earlier bodies of 36 or more dots; a division when a body's dots end up in two groups of 36 or more.

## References

The equations draw on well-known models, adapted here:
- **Rhythm coupling:** Kuramoto's phase coupling for rhythm.
- **Gathering:** the swarmalator model of K. P. O'Keeffe, H. Hong and S. H. Strogatz (*Nature Communications*, 2017) for gathering toward dots in step.
- **Chaotic drive:** the Lorenz system (E. N. Lorenz, *Journal of the Atmospheric Sciences*, 1963) for the crowding climate.
- **Hidden world:** Conway's Game of Life (B3/S23) for the hidden world.
