import os
import pandas as pd

DATA_DIR   = "dataset/fbref/"
FBREF_DEF  = "dataset/fbref/defense.csv"
FBREF_GCA  = "dataset/fbref/gca.csv"
FBREF_INFO = "dataset/fbref/info.csv"


def fbrefGetSeason(season: str, in_dir: str=DATA_DIR, out_file: str="export.csv"):
	"""
	Extract only rows relative to season `season` from the tables in `in_dir`.
	"""
	for table in os.listdir(in_dir):
		if table[:6] == "export" or table[-4:] == ".zip" or table == "info.csv":
			continue

		else:
			print("...querying on", table)	
			in_file  = in_dir + table 
			out_file = in_dir + "export_19-20_" + table

			# read file data
			df = pd.read_csv(in_file, delimiter=',')

			# query the data by season 
			cut_df = df.query(f"season == '{season}'")

			# write new .csv after cut, sorted by id
			cut_df = cut_df.sort_values(by=["id"])
			cut_df.to_csv(out_file)
			
	return



if __name__ == "__main__":
	fbrefGetSeason(season="2019-2020")