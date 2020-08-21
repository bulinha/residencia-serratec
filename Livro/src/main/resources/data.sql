insert into categoria (nome) values  
    ('ficção'),
    ('romance'),
    ('terror');
    
insert into autor (nome) values 
    ('king'),
    ('asimov'),
    ('arthur'),
    ('martin');
    
insert into livro (titulo, autor, data_publicacao, categoria_id) values
    ('eu robo', 'asimov', parsedatetime('1970-02-02', 'yyyy-MM-dd'), 1),
    ('2001 odisseia', 'arthur', parsedatetime('1973-02-02', 'yyyy-MM-dd'), 1),
    ('game of thrones', 'marting', parsedatetime('2005-02-02', 'yyyy-MM-dd'), 2),
    ('a coisa', 'king', parsedatetime('1990-02-02', 'yyyy-MM-dd'), 3);
    
