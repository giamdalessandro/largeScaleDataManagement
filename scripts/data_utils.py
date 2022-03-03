import pandas as pd
import csv

DATA_DIR   = "dataset/fbref/"
FBREF_DEF  = "dataset/fbref/defense.csv"
FBREF_GCA  = "dataset/fbref/gca.csv"
FBREF_INFO = "dataset/fbref/info.csv"


def dataCutSeason(season: str, in_file: str=DATA_DIR, out_file: str="export_std_19-20.csv"):
	in_file  = in_file + "standard.csv" 
	out_file = DATA_DIR + out_file

	# read file data
	df = pd.read_csv(in_file, delimiter=',')

	# query the data by season and tournament
	cut_df = df.query(f"season == '{season}'")

    # write new .csv after cut, sorted by team
	cut_df = cut_df.sort_values(by=["id"])
	cut_df.to_csv(out_file)

	return



if __name__ == "__main__":
	dataCutSeason(season="2019-2020")