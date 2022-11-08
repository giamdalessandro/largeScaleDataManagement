import os
import pandas as pd

FBREF_DIR = "dataset/fbref/"
FM_DIR    = "dataset/fbmanager/"
FM_DATA   = "dataset/fbmanager/datafm20.csv"

DIVISIONS = [
	"Bundesliga",
	"Ligue 1 Conforama",
	#"English Premier Division",
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

def fmGetDivision(division: list=DIVISIONS, in_file: str=FM_DATA, out_file: str="fm20_4leagues_export.csv"):
	out_file = FM_DIR + out_file

	# read file data
	df = pd.read_csv(in_file, delimiter=',')

	# filter the data by division 
	cut_df = df.query(f"Division == '{division[0]}' | Division == '{division[1]}' | Division == '{division[2]}' | Division == '{division[3]}'")

	# write new .csv after cut, sorted by division
	cut_df = cut_df.sort_values(by=["Division"])
	cut_df.to_csv(out_file)
	return

def fbrefGetRoles(in_dir: str=FBREF_DIR, out_file: str="export_roles.csv"):
	"""
	Extract roles info from the export tables in `in_dir`.
	"""
	fbref_file = FBREF_DIR + "info.csv"
	fm_file = FM_DATA
	#out_file = in_dir + "export_roles_" + table

	# read file data
	fbref_df = pd.read_csv(fbref_file, delimiter=',')
	fm_df = pd.read_csv(fm_file, delimiter=',')

	# query the data by season 
	roles_fb_df = fbref_df["position"].drop_duplicates(keep=False)
	roles_fm_df = fm_df["Position"].drop_duplicates(keep=False)

	print("\n", roles_fb_df.head())
	print("\n", roles_fm_df.head())

	all_roles = []
	for role in roles_fb_df:
		all_roles.extend(role.split(","))

	for role in roles_fm_df:
		all_roles.extend(role.split(","))

	s_roles = pd.Series(all_roles).drop_duplicates(keep=False)

	print("\ntotal roles:", len(s_roles))
	print(s_roles.head())




if __name__ == "__main__":
	#fbrefGetSeason(season="2019-2020")
	#fmGetDivision()
	fbrefGetRoles()