import os
import pandas as pd

FBREF_DIR = "dataset/fbref/"
FM_DIR    = "dataset/fbmanager/"
FM_DATA   = "dataset/fbmanager/datafm20.csv"

DIVISIONS = [
	"Bundesliga",
	"Ligue 1 Conforama",
	"English Premier Division",
	"Spanish First Division",
	"Italian Serie A"]


def fbrefGetSeason(season: str, in_dir: str=FBREF_DIR, out_file: str="export.csv"):
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

def fmGetDivision(division: list=DIVISIONS, in_file: str=FM_DATA, out_file: str="fm20_export.csv"):
	out_file = FM_DIR + out_file

	# read file data
	df = pd.read_csv(in_file, delimiter=',')

	# filter the data by division 
	cut_df = df.query(f"Division == '{division[0]}' | Division == '{division[1]}' | Division == '{division[2]}' | Division == '{division[3]}' | Division == '{division[4]}'")

	# write new .csv after cut, sorted by division
	cut_df = cut_df.sort_values(by=["Division"])
	cut_df.to_csv(out_file)
	return


if __name__ == "__main__":
	#fbrefGetSeason(season="2019-2020")
	fmGetDivision()