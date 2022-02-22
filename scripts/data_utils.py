import pandas as pd
import csv

FILE_SCORES = "dataset/WhoScoredFinal1.csv"
FILE_FBMAN  = "dataset/datafm20.csv"


def dataCutSeasonName(season: str, in_file: str=FILE_SCORES, new_file: str="whoScored.csv"):
	new_file = new_file[:-4] + season[-4:] + ".csv"

	# read file data
	df = pd.read_csv(in_file, delimiter=',')

	# query the data by season
	cut_df = df.query(f"seasonName == '{season}'")

	# query the data by season and tournament
	#cut_df = df.query(f"seasonName == '{season}' & tournamentName == 'Premier League' & teamRegionName == 'England'")

    # write new .csv after cut, sorted by team
	cut_df = cut_df.sort_values(by=["teamName"])
	cut_df.to_csv("dataset/" + new_file)

	return


if __name__ == "__main__":
	dataCutSeasonName(season="2019/2020")