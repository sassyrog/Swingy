if [ "$USER" = "rmdaba" ] ; then
	docker exec swingy-mysql mysql --host=localhost --user=root --password="Rootroot3" \
	-e "CREATE DATABASE IF NOT EXISTS Swingy;" -e "USE Swingy;" \
	-e "CREATE TABLE IF NOT EXISTS Players ( \
	ID int(11) NOT NULL, \
	Name varchar(255) NOT NULL,\
	Class varchar(255) NOT NULL DEFAULT 'Underdog',\
	Level int(11) NOT NULL,\
	Attack int(11) NOT NULL,\
	Defense int(11) NOT NULL,\
	HitPoints int(11) NOT NULL,\
	Experience int(11) NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;"
else
	mysql --host=localhost --user=root --password="Rootroot3" \
	-e "CREATE DATABASE IF NOT EXISTS Swingy;" -e "USE Swingy;" \
	-e "CREATE TABLE IF NOT EXISTS Players ( \
	ID int(11) NOT NULL, \
	Name varchar(255) NOT NULL,\
	Class varchar(255) NOT NULL DEFAULT 'Underdog',\
	Level int(11) NOT NULL,\
	Attack int(11) NOT NULL,\
	Defense int(11) NOT NULL,\
	HitPoints int(11) NOT NULL,\
	Experience int(11) NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;"
fi
