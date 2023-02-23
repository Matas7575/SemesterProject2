create schema MusicData;
set schema 'musicdata';

drop table if exists Artist;
create table Artist(
    name varchar,
    isBand boolean
);

drop table if exists User_;
create table User_(
    userid serial PRIMARY KEY,
    username varchar(10),
    password varchar(10),
    email varchar(20)
);

drop table if exists Song cascade ;
create table Song(
    songid serial primary key not null ,
    title varchar(20),
    artist varchar,
    lenght time,
    path varchar
);

drop table if exists Genre;
create table Genre(
    genreid serial primary key,
    type varchar
);

drop table if exists LikedSongs;
create table LikedSongs(
    songid serial,
    foreign key (songid) references Song(songid),
     userid serial,
     foreign key (userid) references User_(userid)
);

drop table if exists Playlist;
create table Playlist(
    userid serial,
    foreign key (userid) references User_(userid),
    name varchar(20),
    isprivate boolean
);

drop table if exists SongWithGenre;
create table SongWithGenre(
    songid serial,
    genreid serial,
    foreign key (songid) references Song(songid),
    foreign key (genreid) references Genre(genreid)
);



---GENRE
insert into genre(type)
values ('disco');

insert into genre(type)
values ('rock');

insert into genre(type)
values ('pop');

insert into genre(type)
values ('trap');

insert into genre(type)
values ('alternative');

insert into genre(type)
values ('hard-rock');

insert into genre(type)
values ('modern-rock');


---User_
insert into user_(username, password, email)
values ('Matas', 'pipipopo', 'matas@gmail.com');

insert into user_(username, password, email)
values ('Chiril', 'suka', 'chiril@gmail.com');

insert into user_(username, password, email)
values ('Dan', 'ugandon', 'dan@gmail.com');

insert into user_(username, password, email)
values ('Dragos', 'sexmachine', 'dragos@gmail.com');

---Song
insert into song(title, artist, lenght, path)
values ('Billie Jean', 'Michael Jackson', '4:55', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Earth Song', 'Michael Jackson', '6:46', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Back in Black', 'AC/DC', '4:53', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Starships', 'Nicki Minaj', '4:22', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Darkness', 'Red Hot Chilli Peppers', '5:02', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Killer', 'Coopex', '3:16', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Feel Nothing', 'The Plot in You', '4:09', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('DJ EBAN', 'Dix Six', '15:00', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Attention', 'Charlie Puth', '3:52', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Shape Of You', 'Ed Sheeran', '4:24', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Ocean Drive', 'Duke Dumont', '3:27', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Self Care', 'Mac Miller', '5:46', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Gods Plan', 'Drake', '5:56', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('AirplaneMode', 'Bones', '1:15', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Dead Man Walking', 'Smiley', '3:21', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Scare Me', 'Lum!x', '2:23', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Nothing Else Matters', 'Metallica', '6:28', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Give In to Me', 'Michael Jackson', '5:29', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Californication', 'Red Hot Chili Peppers', '5:30', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Thinking Out Loud', 'Ed Sheeran', '4:57', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('I Got Love', 'Miyagi', '4:34', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Lights', 'San Holo', '3:50', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Imagination', 'Foster The People', '4:16', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Problems', 'Mother Mother', '3:28', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Raspberry', 'GroupLove', '3:16', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Japan', 'Yot Club', '2:54', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Not Allowed', 'TV Girl', '2:48', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Body', 'Mother Mother', '3:34', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('BALENCIAGA', 'FILV', '2:34', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('the hills', 'Aidan Alexander', '2:26', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Grmi', 'Mili', '2:51', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Chainsmoking', 'Jacob Banks', '3:13', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('u.', 'niteboi', '2:54', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Needs', 'Verzache', '2:57', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('goosebumps', 'Travis Scott', '4:04', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Song 2', 'Blur', '2:02', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Dont look at me', 'POORSTACY', '3:08', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('0 to 100', 'Drake', '4:35', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('By the Sword', 'iamjakehill', '2:06', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('Black Sheep', 'Kailee Morgue', '3:04', '"D:\VIA\SEP2\Documentation\Product backlog.docx"');

insert into song(title, artist, lenght, path)
values ('I Got Bitches', 'A2M', '3:55', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\I Got Bitches Official Video.mp3');

insert into song(title, artist, lenght, path)
values ('Tequilla', 'Speak', '3:29', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Speak & Max Kissaru - Tequila.mp3');

insert into song(title, artist, lenght, path)
values ('World so Cold', 'Three Days Grace', '4:02', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Three Days Grace - World so Cold.mp3');

insert into song(title, artist, lenght, path)
values ('Courtesy Call', 'Thousand Foot Krunch', '3:56', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Thousand Foot Krutch_ Courtesy Call (Official Audio).mp3');
insert into song(title, artist, lenght, path) values ('BOBD', 'Green Day', '8:13', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Green Day - Holiday _ Boulevard of Broken Dreams.mp3');
insert into song(title, artist, lenght, path) values ('Feel Good Inc.', 'Gorillaz', '3:42', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Gorillaz - Feel Good Inc..mp3');
insert into song(title, artist, lenght, path) values ('Kosandra', 'Miyagi & Andy Panda', '3:41', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Miyagi & Andy Panda, Нариман Файлов, Азамат Кудзаев, Сослан Бурнацев - Kosandra.mp3');
insert into song(title, artist, lenght, path) values ('So Familiar', 'Jean Castel', '2:54', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Jean Castel - So Familiar (Demo).mp3');
insert into song(title, artist, lenght, path) values ('Freight Train', 'Alan Jackson', '4:15', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Alan Jackson - Freight Train (JF Jake Bounce Remix).mp3');

---Artist
insert into Artist(name, isBand)
values ('Michael Jackson' , false);

insert into Artist(name, isBand)
values ('AC/DC' , true);

insert into Artist(name, isBand)
values ('Nicki Minaj' , false);

insert into Artist(name, isBand)
values ('Coopex' , false);

insert into Artist(name, isBand)
values ('Red Hot Chilli Peppers' , true);

insert into Artist(name, isBand)
values ('The Plot in You' , true);

insert into Artist(name, isBand)
values ('Dix Six' , false);

insert into Artist(name, isBand)
values ('Charlie Puth' , false);

insert into Artist(name, isBand)
values ('Ed Sheeran' , false);

insert into Artist(name, isBand)
values ('Duke Dumont' , false);

insert into Artist(name, isBand)
values ('Mac Miller' , false);

insert into Artist(name, isBand)
values ('Drake' , false);

insert into Artist(name, isBand)
values ('Bones' , false);

insert into Artist(name, isBand)
values ('Smiley' , false);

insert into Artist(name, isBand)
values ('Lum!x' , false);

insert into Artist(name, isBand)
values ('Metallica' , true);

insert into Artist(name, isBand)
values ('Miyagi' , false);

insert into Artist(name, isBand)
values ('San Holo' , false);

insert into Artist(name, isBand)
values ('Foster The People' , true);

insert into Artist(name, isBand)
values ('Mother Mother' , true);

insert into Artist(name, isBand)
values ('GroupLove' , true);

insert into Artist(name, isBand)
values ('Yot Club' , false);

insert into Artist(name, isBand)
values ('TV Girl' , true);

insert into Artist(name, isBand)
values ('FILV' , false);

insert into Artist(name, isBand)
values ('Aidan Alexander' , false);

insert into Artist(name, isBand)
values ('Mili' , true);

insert into Artist(name, isBand)
values ('Jacob Banks' , false);

insert into Artist(name, isBand)
values ('niteboi' , false);

insert into Artist(name, isBand)
values ('Verzache' , false);

insert into Artist(name, isBand)
values ('Travis Scott' , false);

insert into Artist(name, isBand)
values ('Blur' , true);

insert into Artist(name, isBand)
values ('POORSTACY' , false);

insert into Artist(name, isBand)
values ('iamjakehill' , false);

insert into Artist(name, isBand)
values ('Kailee Morgue' , false);

---Song with Genre
insert into songwithgenre(songid, genreid)
values ('1', '1');

insert into songwithgenre(songid, genreid)
values ('1', '2');
