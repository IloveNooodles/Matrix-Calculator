# Algeo01-20029 - AlgeoKerenGaming

Tugas Besar 1 Aljabar Linear dan Geometri IF20 is a project to build matrice calculator which calculates Polynomial Interpolation, Multiple Linear Regression, Linear Equation System and Determinant. Don't forget to set the precision correctly to get exact result.

---

## File Structure

```
├── README.md
├── bin
│   ├── Aplikasi
│   │   ├── Crammer.class
│   │   ├── Determinan.class
│   │   ├── Interpolasi.class
│   │   ├── Inverse.class
│   │   ├── RLB.class
│   │   └── SistemPersamaanLinear.class
│   ├── Main.class
│   ├── Matrix
│   │   ├── Matrix.class
│   │   └── Operation.class
│   └── Utility
│       ├── IO.class
│       └── Menu.class
├── doc
│   └── Algeo01-20029.pdf
├── lib
│   └── Algeo01-20029.jar
├── src
│   ├── Aplikasi
│   │   ├── Crammer.java
│   │   ├── Determinan.java
│   │   ├── Interpolasi.java
│   │   ├── Inverse.java
│   │   ├── RLB.java
│   │   └── SistemPersamaanLinear.java
│   ├── Main.java
│   ├── Matrix
│   │   ├── Matrix.java
│   │   └── Operation.java
│   └── Utility
│       ├── IO.java
│       └── Menu.java
└── test
    ├── 1_a.txt
    ├── 1_b.txt
    ├── 1_c.txt
    ├── 1_d1.txt
    ├── 1_d2.txt
    ├── 2_a.txt
    ├── 2_b.txt
    ├── 3_a.txt
    ├── 3_b.txt
    ├── 4.txt
    ├── 5.txt
    ├── 6_a.txt
    ├── 6_b.txt
    ├── 6_c.txt
    └── 7.txt
```

---

## How To Use?

### Using source code

1. Clone folder with `git clone https://github.com/IloveNooodles/Algeo01-20029.git` or download the zip file from the github
1. Go to the folder `cd Algeo01-20029`
1. Go to bin folder `cd bin`
1. Run matrix calculator using `java Main` command
1. test folder is used to store input and output txt file
1. you can also run the jar using `java -jar <jar-file.jar>`

### Using Jar Separately (not from source code)

1. Download the jar file
1. To use the jar file, you must make siblings folder and one folder name test
1. It will look like this
1. test file will contain input text and it will be output folder too

```
├── <nama folder jar>
│   └── <jar-file.jar>
│  
└── test
    └── <test-case.txt>

```

1. after you set up the folder `cd <nama folder jar>` to go to the directory
1. use `java -jar <jar-file.jar>` to run the program

---

## Note

Make sure you inputed the matrices right, because we use buffered reader so the number of element in the row or column must be precise
