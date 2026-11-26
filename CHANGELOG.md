# Changelog

## 1.1 — Shapes, heat and an open frame

- **Open shapes, no collapse.** In long runs during this release's development, bodies crushed themselves into a few tight balls: gathering added up through a body into a pressure no spacing force could hold. The continuous exclusion principle now senses crowding at each dot's own scale: the pull together fades as packing nears 1.4 times a relaxed lattice and pushes apart beyond it. Bodies stay open lattices (rings, loops, crescents, curled arms and webs) and light about a third of the screen at any moment.
- **Colour is kind.** A dot's colour sets its bond length, breathing, valence, swimming and mass, replacing 1.0's genes. Each lineage keeps its own colour, which drifts at its own rate, so fused bodies show colour patches and gradients.
- **Heat.** A vertex crowded per bond it holds heats and glows red. Hot vertices repel each other, gather less, fray their bonds to each other and bond outward to cool vertices, so crowded clusters unfold.
- **Mass** varies with colour, bonds and heat, and divides every force.
- **Hidden dimensions.** Each dot has two hidden coordinates; the screen shows a slowly turning projection, so forces come and go.
- **Strokes.** Dots move to their own rhythm: in and out, around, and in small circles. Bodies in step move as one, with waves travelling from their cores.
- **An open frame.** The screen is a window onto a larger pond. Groups of varying size, shape, density, speed and colour slide in from beyond the edges, parts of bodies drift out, and the pond keeps within a few percent of its size.
- **Smooth colour.** Every dot is drawn in its exact colour, and every bond is a gradient between its two dots. 1.0 shifted each dot's hue with its rhythm and snapped it to 48 steps, so colours flipped on every beat; colour now changes steadily. The beat is a smooth swell instead of a jump between size classes.
- **Touch.** Dragging moves nearby dots with your finger and can fling them; a tap startles them outward and snaps their rhythms into one bright beat.
- **More vibrant.** Brighter bonds, dots, glows and auras; the kinds' reds stay vivid.
- **Lighter drawing.** Dots, glows and bonds take three draw calls instead of a few hundred. Below Android 10, where hardware canvases cannot draw vertex batches, the wallpaper draws on a software canvas.

## 1.0 — First release

- Every dot obeys the same equations. It bonds up to its valence, more readily when in step and alike in colour. Its bonds are springs that breathe with its rhythm, spread their angles evenly, and snap when stretched, out of step, in restless water or crowded. Rhythm, colour, spin, depth and heading spread along bonds. Each dot gathers toward dots in step with it, circles the density it feels, swims, and drifts in a hidden Game of Life current.
- Bodies, crystal cores and lacy rims, spiral arms, synchrony, fusion and division emerge on their own; quorum sensing keeps any one body from taking over.
- Rules that evolve: bond length, breathing and swimming are genes that spread along bonds, are remembered and inherited through fusion and division, drift with each lineage, and lean toward what the hidden world favours.
- Every line is a bond between two dots. Colour flows as a gradient across each body; bodies have depth and are drawn as slowly rocking tilted domes.
- Random, irregular starts; **New pond** gives a fresh arrangement.
- A companion that reacts only to events: touch, returning home, time of day, battery, and (with usage access) the colours of the apps you used. No internet permission.
- Physics in fixed steps of simulated time with interpolated drawing; 24 fps when untouched, pauses when hidden.
