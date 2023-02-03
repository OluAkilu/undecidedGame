# undecidedGame
PROJECT: “undecidedgame” - ideas (Attack Defense Simulator) A.D.S

Premise: Basic “turn-based” 1v1 Fight Simulator (using CPUs–for now)
The game will simulate itself in entirety by using the “turn” method–explained below–until an ending scenario occurs.

Possible Values:
Health/HP Values (when this number reaches 0 or anything less than it, the game ends and the “player” with 0 HP loses–in the scenario that both “players” are left with 0 HP at the end of the turn, the game results in a tie.)

Possible Actions: each player has a 50% chance of doing either of these
Attack (reduces HP of opposing “player” by a random integer value from 1-10, has a 30% chance to crit which doubles dmg dealt)
Defend (reduces dmg received by 50% always, but has 50% chance of failing)

Ending Scenarios: this scenarios are only checked for at the end of each turn
HP of CPUs reaches 0 or below - this is counted as a win or a knockout for the other player
HP of both CPUs reaches 0 or below - this is counted as a double knockout
Number of turns reaches 10 - this is counted as a stalemate

Classes:
undecidedGame

Variables:
HP - Amount of dmg you can take before a knockout always starts at 100
Luck? - Increases the percentage of a successful critical attack or defense by a percentage corresponding to its int value. Ex: 10 Luck = 10% additional chance to crit or defend. This always starts at 0

Working Functionalities (as of 2/3/23):
Defense function (have not implemented a chance of failure)
Attack function (seems to be working properly, still deciding default values for each attribute)
Basic Dialogue (x is attacking, y is defending…)
Endcase Scenarios (x/y wins, game is a draw)
