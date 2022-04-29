# LSDM project

Project for Large Scale Data Management 20/21, Sapienza University of Rome. 


## Dataset
- [fbref soccer stats](https://www.kaggle.com/biniyamyohannes/soccer-player-data-from-fbrefcom) on Kaggle; data on 5 division:
  - Bundesliga (20), Ligue 1 (13), La Liga (12), Premier League (9), Serie A (11)

| *fbref*       | #rows | #rows(19-20) | #cols |
| ------------- | ----- | ------------ | ----- |
| info          | 2933  | N/A          | 13    |
| defense       | 21365 | 2458         | 31    |
| gca           | 21365 | 2458         | 24    |
| keeper        | 2285  | 225          | 26    |
| keeper_adv    | 2083  | 198          | 33    |
| passing       | 21365 | 2458         | 30    |
| passing_types | 21365 | 2458         | 33    |
| playing_time  | 23021 | 2670         | 29    |
| possession    | 21365 | 2458         | 32    |
| shooting      | 19955 | 2328         | 25    |
| standard      | 23021 | 2670         | 32    |
| misc          | 21898 | 2551         | 24    |

- [football manager 2020](https://www.kaggle.com/ktyptorio/football-manager-2020) data on Kaggle

| *fm 2020* | #rows  | #rows (main 5 divisions) | #cols |
| --------- | ------ | ------------------------ | ----- |
| datafm20  | 144752 | 5117                     | 65    |


## Information Integration
Integrate information from one or more sources and obtain a reconciled view of the data. Essentially all examples inf-int projects follows the same work-flow:

- source DBs (insight on dataset and heterogeneity)
- source schemas
- global schema
- Global Schema Axioms (keys, foreign keys)
- GAV mapping (declarative) 
- Pentaho implementation
- Queries and results (5/6)

## Big Data Management
