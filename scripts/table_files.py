import os
import pandas as pd

INPUT_PATH = 'src/main/scala/it/sapienza/lsdm/input/'
MODEL_PATH = 'src/main/scala/it/sapienza/lsdm/model/'
SQL_PATH   = 'src/main/scala/it/sapienza/lsdm/sparksql/'


def createModelAndSqlFiles(src_file: str, table: str):
	table_file = table + '.scala'
	sql_file   = SQL_PATH + table + '.sql'

	src_file   = INPUT_PATH+src_file
	df = pd.read_csv(src_file, delimiter=',')
	cols = list(df.columns)
	cols[0] = 'pid'

	# model file template
	model_file = MODEL_PATH+table_file
	with open(model_file, "w") as mod_f:
		mod_f.write('package it.sapienza.lsdm.model\n\nimport slick.jdbc.PostgresProfile.api._\n\n\n')
		mod_f.write(f'case class {table}(\n')

		for attr in cols:
			mod_f.write(f'\t{attr} : Option[Double],\n')
		mod_f.write(')\n\n\n')

		mod_f.write(f'class {table}Entity(tag: Tag) extends Table[{table}](tag, "{table}")')
		mod_f.write(' {\n')

		for attr in cols:
			mod_f.write(f'\tdef {attr} = column[Option[Double]]("{attr}")\n')

		mod_f.write('\n\tval pidFK = TableQuery[PlayerEntity]\n')
		mod_f.write('\tdef pid_fk = foreignKey("pid_fk", pid, pidFK)(_.pid, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)\n')	
		mod_f.write(f'\tdef * = ({cols[1:]}) <> ({table}.tupled, {table}.unapply)\n')

		mod_f.write('}\n')

	# sql file template
	with open(sql_file, "w") as sql_f:
		sql_f.write('select\n\tfb.id as pid\n')

		for attr in cols[1:]:
			sql_f.write(f'\tcast(fb.{attr} as double) as {attr}\n')

		sql_f.write('from Fbref fb\n')
		sql_f.write('where fb.id in (select id from (Fm20 fm join FbrefInfo fbinfo on (fm.Name = fbinfo.name)))\n')
		sql_f.write('order by pid\n')


	print(table,':',cols,'\n')
	return



if __name__ == "__main__":
	for src_f in os.listdir(INPUT_PATH):
		table_name = src_f[6:-15]
		
		if src_f[:5] == 'fbref' and (table_name not in ['info','gca','defense']):
			table_name = table_name.capitalize() + 'Stats'
			createModelAndSqlFiles(src_f,table_name)

