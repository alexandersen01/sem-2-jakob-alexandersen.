# SUDOKU!

Vi holder alle spillet [Sudoku](https://en.wikipedia.org/wiki/Sudoku) nært og kjært. 
I dag vil du få prøve deg på det! Spillet har tre ulike vanskelighetsgrader,
så velg med **omhu**!

**Litt informasjon om måten jeg har håndtert dette på:**
Istedenfor å hardcode en mlrd mulige sudoku-brett, så har jeg hentet dem fra et dataset laget av
[Gordon Royle fra University of Western Australia](https://web.archive.org/web/20131019184812if_/http://school.maths.uwa.edu.au/~gordon/sudokumin.php).
Dette datasettet inneholder rundt 49 000 sudokubrett, alle med 17 gitte tall.
Videre har jeg laget en liten funksjon som henter ut stringene fra datasettet, og konverterer dem til et brukbart brett.

