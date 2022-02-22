import requests
import pandas as pd
import csv

from bs4 import BeautifulSoup

WORK_DIR = "/media/zascerta/DATA/Universalis/eng_computer_science/largeScaleDataManagement/project/"


def dumpNFTStats(out_file : str="openSea_dump.csv"):
    """ Cryptoslams Data, no API, need to dump the website. """
    url = "https://cryptoslam.io/"
    new_file = WORK_DIR + out_file
    content = requests.get(url).content
    soup = BeautifulSoup(content,'html.parser')
    table = soup.find("table")
    for i,tr in enumerate(table.findAll('tr')):
        row = []
        for td in tr.findAll('td'):
            row.append(td.text)
        if i == 0: # write header
            with open(new_file, 'w') as f:
                writer = csv.DictWriter(f, fieldnames=["id","collection","dirt","sales","change(24h)","buyers", "txs"])
                writer.writeheader() # header
        else:
            with open(new_file, 'a') as f:
                writer = csv.writer(f, delimiter=",")
                writer.writerow(row)

    # clean NFT dumped data
    df = pd.read_csv(new_file, delimiter=',', parse_dates=True)
    for col in df.columns:
        df[col] = df[col].apply(lambda row: str(row).strip())

    # overwrite the csv, with only the necessary cols
    print(df.head())
    df.to_csv(new_file, columns=["collection","sales","change(24h)","buyers", "txs"])
    return

def openSea_API():
    url_stats = "https://api.opensea.io/api/v1/collection/doodles-official/stats"
    url_collections = "https://api.opensea.io/api/v1/collections?offset=0&limit=300"

    headers = {"Accept": "application/json"}
    response = requests.request("GET", url_collections, headers=headers)
    print(response.text)


if __name__ == "__main__":
    # dumpNFTStats()
    openSea_API()