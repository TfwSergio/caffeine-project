# Caffeine Quest reflection

Name:

## Five questions before coding

1. Purpose: Merge takes two sorted piles and combines them into one sorted pile. If two items are tied, the one from the left pile stays first.
2. Inputs and outputs: Merge gets the list, a scratch list, the rule for which item comes first, and three numbers that show where the two sorted piles are. It puts that part of the list in order and tells you how many comparisons it made.
3. Constraints:Both piles are already sorted before merge starts. I can’t use Java’s built-in sorting, and I have to use the comparator I’m given.
4. Edge cases:When one pile runs out, I copy over whatever is left in the other pile. When two items are tied, I take the left one.
5. Test oracle:The output is in the right order, nothing is missing or duplicated, tied items stayed in their original order, and all 12 SortCheck checks pass.

## Explore Demo mode

Starting latitude/longitude:[37.3022],[-120.483]

| Filter | Rank | Store ID / name | Distance in miles |
|---|---:|---|---:|
| All stores | 1 | | |   0.08      No          Main Place - Merced / Merced - Merced County
| All stores | 2 | | |	1.20      No          580 West Olive - Merced / Merced - Merced County
| Drive-through only | 1 | | |    1.84      Yes         Childs & Hwy 99 - Merced / Merced - Merced County
| Drive-through only | 2 | | |	7.32      Yes         Bellevue & Shaffer - Atwater / Atwater - Merced County
| Drive-through only | 3 | | |	7.83      Yes         Applegate & Hwy 99 - Atwater / Atwater - Merced County

What changed, and why would alphabetical order not answer this search?


//Alphabetical order would not answer this search because it wouldnt be relevant to the person's location. the reason the results changed was because one wanted places exclusively with drive through and the other did all of them with or without.

## Hand trace: merge [2, 7] and [3, 5]

| Step | Compared values (if any) | Item copied | Buffer so far |
|---|---|---|---|
| 1 | | | |
The merge compares the front items of each half and copies the smaller one
into the buffer. This took 3 comparisons. When the right half ran out, the
leftover 7 from the left half was copied over without another comparison,
giving [2, 3, 5, 7]
## Validation

Final SortCheck output or evidence filename: 

Additional test: input / expected output / actual output / reason:

Student-mode first three results for the two original searches:

How do they compare with Demo mode? Student map evidence filename:

## Investigate one feature (150-250 words)

Topic and class/method:

Short relevant code excerpt:

Explanation and concrete example:

Source consulted (title and URL or course reference):

## Customization

Feature:

Files changed and explanation:

New-feature test and result:

Default-behavior regression check:

## Algorithm explanation

1. Time complexity and reasoning: The list is split in half over and over, and each round of merging touches every item once.
2. Auxiliary space: its like an extra space for memory to stay while its being modified.
3. Stability and how my code preserves it: Stable means tied items stay in their original order. In my code, the right item only goes first if it is strictly smaller
4. Why Demo/Student comparison counts may differ: Demo uses Java’s built-in sort and Student uses my merge sort. They’re different methods, so they can make a different number of comparisons, even though the final order is the same.
5. Why a single short timing is insufficient: One quick run can be thrown off by other things the computer is doing, and the list is so small that the time is tiny. You’d need to run it many times to say which one is really faster.

## Demonstration checklist

- [ ] Student search and map
- [ ] Explain one merge comparison
- [ ] Show customization
