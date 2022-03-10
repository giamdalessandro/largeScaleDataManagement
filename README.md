# LSDM project

Project for Large Scale Data Management 20/21, Sapienza University of Rome. 



## Dataset
- [fbref soccer stats](https://www.kaggle.com/biniyamyohannes/soccer-player-data-from-fbrefcom) on Kaggle;



Leagues:

- (20) Bundesliga
- (13) Ligue 1
- (12) La Liga 
- (9) Premier League
- (11) Serie A

|               | #rows | #rows(19-20) | #cols |
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



## Information Integration

Integrate information from one or more sources and obtain a reconciled view of the data. Three main phases:

- **Phase 1: Data Gathering**
  - Select domain of interest;
  - Define task to perform in the domain;
- **Phase 2: Modeling**, define the data integration system describing the domain of interest:
  - source schema;
  - target schema;
  - mapping layer; 
  - queries on the target schema;
- **Phase 3: Implementation**, convert the logical model into software:



Essentially all examples inf-int projects follows the same work-flow:

- source DBs (insight on dataset and heterogeneity)
- source schemas
- global schema
- Global Schema Axioms (keys, foreign keys)
- GAV mapping (declarative) 
- Pentaho implementation
- Queries and results (5/6)



## Big Data Management