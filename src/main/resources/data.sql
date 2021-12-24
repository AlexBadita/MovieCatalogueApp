insert into language values(1, 'English')
insert into language values(2, 'French')
insert into language values(3, 'Romanian')

insert into genre values(1, 'Drama')
insert into genre values(2, 'Horror')
insert into genre values(3, 'Action')

insert into catalogue_entry(id, name, release_year, genre_id, language_id, about) values(1, 'The Avengers', 2012, 3, 1, 'Earth`s mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.')
insert into movie(id, duration) values(1, 143)

insert into catalogue_entry(id, name, release_year, genre_id, language_id, about) values(2, 'The Conjuring', 2013, 2, 1, 'Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.')
insert into movie(id, duration) values(2, 112)

insert into catalogue_entry(id, name, release_year, genre_id, language_id, about) values(3, 'Cernobîl', 2019, 1, 1, 'In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world`s worst man-made catastrophes.')
insert into tvshow(id, seasons, episodes) values(3, 1, 5)

insert into catalogue_entry(id, name, release_year, genre_id, language_id, about) values(4, 'Vlad', 2019, 1, 3, 'After being sent behind bars by the ones closest to him, a young man changes his identity and seeks revenge.')
insert into tvshow(id, seasons, episodes) values(4, 4, 52)