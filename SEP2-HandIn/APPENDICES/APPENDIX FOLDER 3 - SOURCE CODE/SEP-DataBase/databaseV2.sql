Drop SCHEMA IF EXISTS MusicData CASCADE ;
CREATE SCHEMA MusicData;
set schema 'musicdata';

drop table if exists Artist CASCADE ;
create table Artist
(
    name   varchar,
    isBand boolean
);

drop table if exists User_ CASCADE ;
create table User_
(
    userid   serial PRIMARY KEY,
    username varchar not null,
    password varchar not null,
    email    varchar not null,
    artist   boolean
);

drop table if exists Song cascade;
create table Song
(
    songid serial primary key not null,
    title  varchar,
    artist varchar,
    lenght time,
    path   varchar
);

drop table if exists Genre CASCADE ;
create table Genre
(
    genreid serial primary key,
    type    varchar
);

drop table if exists LikedSongs;
create table LikedSongs
(
    songid serial,
    foreign key (songid) references Song (songid),
    userid serial,
    foreign key (userid) references User_ (userid)
);

drop table if exists Playlist;
create table Playlist
(
    userid    serial,
    foreign key (userid) references User_ (userid),
    name      varchar,
    isprivate boolean
);

drop table if exists SongWithGenre;
create table SongWithGenre
(
    songid  serial,
    genreid serial,
    foreign key (songid) references Song (songid),
    foreign key (genreid) references Genre (genreid)
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
insert into user_(username, password, email, artist)
values ('Admin', 'admin', 'admin@gmail.com', true);

---Song
insert into song(title, artist, lenght, path)
values ('Billie Jean', 'Michael Jackson', '4:55',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Michael Jackson - Billie Jean.mp3');
insert into song(title, artist, lenght, path)
values ('Earth Song', 'Michael Jackson', '6:46',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Michael Jackson - Earth Song.mp3');
insert into song(title, artist, lenght, path)
values ('Back in Black', 'AC/DC', '4:53', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\AC_DC - Back In Black.mp3');
insert into song(title, artist, lenght, path)
values ('Starships', 'Nicki Minaj', '4:22',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Nicki Minaj - Starships (Explicit).mp3');
insert into song(title, artist, lenght, path)
values ('Dark Necesities', 'Red Hot Chilli Peppers', '5:02',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Red Hot Chili Peppers - Dark Necessities.mp3');
insert into song(title, artist, lenght, path)
values ('Killer', 'Coopex', '3:16', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Coopex, Swisha T & M.I.M.E - Killer.mp3');
insert into song(title, artist, lenght, path)
values ('Feel Nothing', 'The Plot in You', '4:09',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\The Plot In You - FEEL NOTHING.mp3');
insert into song(title, artist, lenght, path)
values ('DJ EBAN', 'Dix Six', '1:50', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\DJ Eban [BASS BOOSTED].mp3');
insert into song(title, artist, lenght, path)
values ('Attention', 'Charlie Puth', '3:52', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Charlie Puth - Attention.mp3');
insert into song(title, artist, lenght, path)
values ('Shape Of You', 'Ed Sheeran', '4:24', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Ed Sheeran - Shape of You.mp3');
insert into song(title, artist, lenght, path)
values ('Ocean Drive', 'Duke Dumont', '3:27', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Duke Dumont - Ocean Drive.mp3');
insert into song(title, artist, lenght, path)
values ('Self Care', 'Mac Miller', '5:46', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Mac Miller - Self Care.mp3');
insert into song(title, artist, lenght, path)
values ('Gods Plan', 'Drake', '5:56', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Drake - God''s Plan.mp3');
insert into song(title, artist, lenght, path)
values ('AirplaneMode', 'Bones', '1:15', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\BONES - AirplaneMode.mp3');
insert into song(title, artist, lenght, path)
values ('Dead Man Walking', 'Smiley', '3:21', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Smiley - Dead man walking.mp3');
insert into song(title, artist, lenght, path)
values ('Scare Me', 'Lum!x', '2:23',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\LUM!X, KSHMR, Gabry Ponte - Scare Me (feat. Karra).mp3');
insert into song(title, artist, lenght, path)
values ('Nothing Else Matters', 'Metallica', '6:28',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Metallica_ Nothing Else Matters (Official Music Video).mp3');
insert into song(title, artist, lenght, path)
values ('Give In to Me', 'Michael Jackson', '5:29',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Michael Jackson - Give In To Me.mp3');
insert into song(title, artist, lenght, path)
values ('Californication', 'Red Hot Chili Peppers', '5:30',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Red Hot Chili Peppers - Californication.mp3');
insert into song(title, artist, lenght, path)
values ('Thinking Out Loud', 'Ed Sheeran', '4:57',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Ed Sheeran - Thinking Out Loud.mp3');
insert into song(title, artist, lenght, path)
values ('I Got Love', 'Miyagi', '4:34',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Miyagi & Эндшпиль feat. Рем Дигга - I Got Love.mp3');
insert into song(title, artist, lenght, path)
values ('Lights', 'San Holo', '3:50',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\San Holo vs. Kanye West - Lights (Nitti Gritti Remix).mp3');
insert into song(title, artist, lenght, path)
values ('Imagination', 'Foster The People', '4:16',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Foster The People - Imagination.mp3');
insert into song(title, artist, lenght, path)
values ('Problems', 'Mother Mother', '3:28',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Mother Mother __ Problems (LYRICS).mp3');
insert into song(title, artist, lenght, path)
values ('Raspberry', 'GroupLove', '3:16', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Grouplove - Raspberry.mp3');
insert into song(title, artist, lenght, path)
values ('Japan', 'Yot Club', '2:54', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Yot Club - Japan.mp3');
insert into song(title, artist, lenght, path)
values ('Not Allowed', 'TV Girl', '2:48', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\TV Girl - Not Allowed.mp3');
insert into song(title, artist, lenght, path)
values ('Body', 'Mother Mother', '3:34', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Mother Mother - Body.mp3');
insert into song(title, artist, lenght, path)
values ('BALENCIAGA', 'FILV', '2:34',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\FILV - BALENCIAGA (Y3MR$ Remix) Lyrics🎵.mp3');
insert into song(title, artist, lenght, path)
values ('the hills', 'Aidan Alexander', '2:26',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Aidan Alexander - the hills.mp3');
insert into song(title, artist, lenght, path)
values ('Grmi', 'Mili', '2:51', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Mili - GRMI.mp3');
insert into song(title, artist, lenght, path)
values ('Chainsmoking', 'Jacob Banks', '3:13', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Jacob Banks - Chainsmoking.mp3');
insert into song(title, artist, lenght, path)
values ('u.', 'niteboi', '2:54', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\niteboi - u..mp3');
insert into song(title, artist, lenght, path)
values ('Needs', 'Verzache', '2:57', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Verzache - Needs.mp3');
insert into song(title, artist, lenght, path)
values ('goosebumps', 'Travis Scott', '4:04',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Travis Scott - goosebumps ft. Kendrick Lamar.mp3');
insert into song(title, artist, lenght, path)
values ('Song 2', 'Blur', '2:02', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Blur - Song 2.mp3');
insert into song(title, artist, lenght, path)
values ('Dont look at me', 'POORSTACY', '3:08',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\POORSTACY - Don''t Look At Me.mp3');
insert into song(title, artist, lenght, path)
values ('0 to 100', 'Drake', '4:35', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Drake - 0 To 100 _ The Catch Up.mp3');
insert into song(title, artist, lenght, path)
values ('By the Sword', 'iamjakehill', '2:06', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\iamjakehill - By the Sword.mp3');
insert into song(title, artist, lenght, path)
values ('Black Sheep', 'Kailee Morgue', '3:04',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Kailee Morgue - Black Sheep (Audio).mp3');
insert into song(title, artist, lenght, path)
values ('I Got Bitches', 'A2M', '3:55', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\I Got Bitches Official Video.mp3');
insert into song(title, artist, lenght, path)
values ('Tequilla', 'Speak', '3:29', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Speak & Max Kissaru - Tequila.mp3');
insert into song(title, artist, lenght, path)
values ('World so Cold', 'Three Days Grace', '4:02',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Three Days Grace - World so Cold.mp3');
insert into song(title, artist, lenght, path)
values ('Courtesy Call', 'Thousand Foot Krunch', '3:56',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Thousand Foot Krutch_ Courtesy Call (Official Audio).mp3');
insert into song(title, artist, lenght, path)
values ('Boulevard Of Broken Dreams', 'Green Day', '8:13',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Green Day - Holiday _ Boulevard of Broken Dreams.mp3');
insert into song(title, artist, lenght, path)
values ('Feel Good Inc.', 'Gorillaz', '3:42', 'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Gorillaz - Feel Good Inc..mp3');
insert into song(title, artist, lenght, path)
values ('Kosandra', 'Miyagi & Andy Panda', '3:41',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Miyagi & Andy Panda, Нариман Файлов, Азамат Кудзаев, Сослан Бурнацев - Kosandra.mp3');
insert into song(title, artist, lenght, path)
values ('So Familiar', 'Jean Castel', '2:54',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Jean Castel - So Familiar (Demo).mp3');
insert into song(title, artist, lenght, path)
values ('Freight Train', 'Alan Jackson', '4:15',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\Alan Jackson - Freight Train (JF Jake Bounce Remix).mp3');
insert into song(title, artist, lenght, path)
values ('Se Acabo', 'The Beatnuts', '3:28',
        'D:\VIA\SEP2\SEP-DataBase\DatabaseMusic\The Beatnuts - Se Acabo Remix feat. Method Man - Classic Nuts Vol. 1.mp3');

---Artist
insert into Artist(name, isBand)
values ('Michael Jackson', false);

insert into Artist(name, isBand)
values ('AC/DC', true);

insert into Artist(name, isBand)
values ('Nicki Minaj', false);

insert into Artist(name, isBand)
values ('Coopex', false);

insert into Artist(name, isBand)
values ('Red Hot Chilli Peppers', true);

insert into Artist(name, isBand)
values ('The Plot in You', true);

insert into Artist(name, isBand)
values ('Dix Six', false);

insert into Artist(name, isBand)
values ('Charlie Puth', false);

insert into Artist(name, isBand)
values ('Ed Sheeran', false);

insert into Artist(name, isBand)
values ('Duke Dumont', false);

insert into Artist(name, isBand)
values ('Mac Miller', false);

insert into Artist(name, isBand)
values ('Drake', false);

insert into Artist(name, isBand)
values ('Bones', false);

insert into Artist(name, isBand)
values ('Smiley', false);

insert into Artist(name, isBand)
values ('Lum!x', false);

insert into Artist(name, isBand)
values ('Metallica', true);

insert into Artist(name, isBand)
values ('Miyagi', false);

insert into Artist(name, isBand)
values ('San Holo', false);

insert into Artist(name, isBand)
values ('Foster The People', true);

insert into Artist(name, isBand)
values ('Mother Mother', true);

insert into Artist(name, isBand)
values ('GroupLove', true);

insert into Artist(name, isBand)
values ('Yot Club', false);

insert into Artist(name, isBand)
values ('TV Girl', true);

insert into Artist(name, isBand)
values ('FILV', false);

insert into Artist(name, isBand)
values ('Aidan Alexander', false);

insert into Artist(name, isBand)
values ('Mili', true);

insert into Artist(name, isBand)
values ('Jacob Banks', false);

insert into Artist(name, isBand)
values ('niteboi', false);

insert into Artist(name, isBand)
values ('Verzache', false);

insert into Artist(name, isBand)
values ('Travis Scott', false);

insert into Artist(name, isBand)
values ('Blur', true);

insert into Artist(name, isBand)
values ('POORSTACY', false);

insert into Artist(name, isBand)
values ('iamjakehill', false);

insert into Artist(name, isBand)
values ('Kailee Morgue', false);

---Song with Genre
insert into songwithgenre(songid, genreid)
values ('1', '1');

insert into songwithgenre(songid, genreid)
values ('1', '2');

