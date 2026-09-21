

Readme · MD
# SearchEngine
 
A small Java information-retrieval engine built from scratch on top of custom
data structures (linked lists, array lists, and a binary search tree — no
external libraries). It reads a corpus of documents from a CSV file, builds
several index structures over them, and lets you run term lookups, boolean
queries, and frequency-ranked searches from an interactive console menu.
 
## Features
 
- **CSV document reader** (`Reader`) — loads documents and their IDs from
  `dataset.csv`, lowercasing content for indexing while keeping the original
  text for display.
- **Text preprocessing** (`preprocessing`) — strips punctuation, removes stop
  words (from `stop.txt`), and extracts the vocabulary of unique terms across
  the corpus.
- **Three index implementations** over the same corpus, so their design and
  performance can be compared:
  - `Index` — a simple forward index: for each document, a list of its terms.
  - `InvertedIndex` — a term → list of `(document ID, frequency)` inverted
    index backed by linked lists.
  - `BSTInvertedIndex` — the same inverted index, but terms are stored as
    keys in a binary search tree (`BST`/`BSTNode`) for faster lookup.
- **Boolean search** (`Query`, `QueryBST`) — evaluates queries such as
  `market OR sports AND warming` against the inverted index, supporting
  `AND`/`OR` operators.
- **Ranked search** (`Ranking`) — scores and ranks documents by summed term
  frequency across all query terms, for both the linked-list and BST
  inverted indexes.
- **Custom collections** — `LinkedList`, `ArrayList`, `Node`, `BSTNode`/`BST`,
  all implementing a shared `List<T>` interface with a cursor-style API
  (`findFirst`, `findNext`, `retrieve`, `insert`, `update`, `remove`, etc.).
## Project structure
 
```
SearchEngine/
├── src/
│   ├── Main.java              # Entry point / interactive menu
│   ├── Reader.java            # Loads dataset.csv into memory
│   ├── preprocessing.java     # Punctuation/stop-word removal, vocabulary extraction
│   ├── Index.java             # Forward index (document -> terms)
│   ├── InvertedIndex.java     # Inverted index (term -> documents), list-based
│   ├── InvertedIndexNode.java # (document_id, frequency) pair used by inverted indexes
│   ├── BSTInvertedIndex.java  # Inverted index backed by a BST
│   ├── BSTNode.java           # BSTNode + BST implementation
│   ├── Query.java             # Boolean search over InvertedIndex
│   ├── QueryBST.java          # Boolean search over BSTInvertedIndex
│   ├── Ranking.java           # Frequency-based ranked search
│   ├── LinkedList.java        # Custom generic linked list
│   ├── ArrayList.java         # Custom generic array list
│   ├── Node.java              # Linked list node
│   └── List.java              # Shared collection interface
├── dataset.csv                 # Sample corpus (Document ID, Content)
├── stop.txt                    # Stop word list
├── SearchEngine.iml             # IntelliJ IDEA module file
└── out/production/SearchEngine  # Compiled .class files
```
 
## Requirements
 
- Java JDK 8 or later
- No external dependencies — everything is implemented with plain Java and
  the project's own data structures
## Dataset format
 
`dataset.csv` is a simple two-column CSV:
 
```
Document ID,Content,
0,"Market analysts forecast a significant shift as emerging tech startups...",
1,Tonight's basketball game features the league's top scorers...,
```
 
- The first line is a header and is skipped.
- Each subsequent line is `<id>,<content>`; the reader stops at the first
  blank/malformed ID.
`stop.txt` contains one stop word per line and is used to filter out common
words (e.g. "the", "a", "and") before indexing.
 
## Building and running
 
### From the command line
 
```bash
cd SearchEngine/src
javac -d ../out/production/SearchEngine *.java
cd ../out/production/SearchEngine
java Main
```
 
Make sure `dataset.csv` and `stop.txt` are accessible from the working
directory you run `java Main` from (they're read using relative paths), or
copy them alongside the compiled classes.
 
### From IntelliJ IDEA
 
Open the project folder (it already contains `SearchEngine.iml`), let the
IDE index it, and run `Main.java` directly.
 
## Usage
 
On startup, `Main` builds the forward index, the linked-list inverted index,
and the BST inverted index, prints a table of indexed documents, and then
presents a menu:
 
```
Welcome To Our Search Engine
Select an operation:
1=Retrieve a term
2- Boolean Retrieval
3- Ranked Retrieval
4- Indexed Documents
5- Indexed Tokens
6- EXIT
```
 
- **1 — Retrieve a term**: choose which index to query (plain index,
  inverted index, or BST inverted index), then enter a search term.
- **2 — Boolean Retrieval**: enter a query using `AND`/`OR`, e.g.
  `market OR sports AND warming`.
- **3 — Ranked Retrieval**: enter one or more terms; documents are ranked by
  combined term frequency.
- **4 — Indexed Documents**: lists documents with their word counts.
- **5 — Indexed Tokens**: lists indexed terms and how many documents each
  appears in.
- **6 — EXIT**: quits the program.
## Notes
 
- This is a coursework-style / educational implementation focused on
  demonstrating classic IR data structures (forward index, inverted index,
  BST-backed index) and algorithms (boolean AND/OR retrieval, frequency
  ranking) built without relying on Java's standard collections.
- The `out/production/SearchEngine` directory contains pre-built `.class`
  files from an IntelliJ build; you can safely delete and regenerate it.
- Some menu options in `Main.java` are stubbed out (the `switch` cases are
  empty) and would need to be wired up to `Query`, `QueryBST`, and `Ranking`
  to be fully interactive — currently a few examples are commented out
  directly in `main()`.
 

