# SUDOKU!

Vi holder alle spillet [Sudoku](https://en.wikipedia.org/wiki/Sudoku) nært og kjært. 
I dag vil du få prøve deg på det! Spillet har tre ulike vanskelighetsgrader,
så velg med **omhu**!

**Litt informasjon om måten jeg har håndtert dette på:**
Istedenfor å hardcode en mlrd mulige sudoku-brett, så har jeg hentet dem fra et datasett laget av
[Gordon Royle fra University of Western Australia](https://web.archive.org/web/20131019184812if_/http://school.maths.uwa.edu.au/~gordon/sudokumin.php).
Dette datasettet inneholder rundt 49 000 sudokubrett, alle med 17 gitte tall.

**Men** det viser seg at det å løse et sudoku-brett med bare 17 gitte tall er ganske vanskelig.
Derfor har jeg laget 3000 brett med varierende vanskelighetsgrader. 
Jeg tok utgangspunkt i datasettet fra Gordon Royle, og brukte py-sydoku for å løse alle disse brettene.
Videre gjorde jeg disse løste brettene om til strings, og erstattet tilfeldige tall med '0'. Antall nuller baseres på vanskelighetsgraden.
[Driverkoden til sudoku-generatoren finner du på min private github](https://github.com/alexandersen01/man-2).
