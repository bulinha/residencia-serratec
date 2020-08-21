insert into categoria (nome) values  
    ('ficção'),
    ('romance'),
    ('terror');
    
insert into autor (nome) values 
    ('king'),
    ('asimov'),
    ('arthur'),
    ('martin');
    
insert into livro (titulo, data_publicacao, categoria_id) values
    ('eu robo', parsedatetime('1970-02-02', 'yyyy-MM-dd'), 1),
    ('2001 odisseia',  parsedatetime('1973-02-02', 'yyyy-MM-dd'), 1),
    ('game of thrones',  parsedatetime('2005-02-02', 'yyyy-MM-dd'), 2),
    ('a coisa', parsedatetime('1990-02-02', 'yyyy-MM-dd'), 3),
    ('homem bicentenario',parsedatetime('1972-02-02', 'yyyy-MM-dd'), 1);
    
insert into livro_autor (livro_id, autor_id) values 
       (1,2),
       (1,3),
       (2,3),
       (3,4),
       (4,1),
       (5,2);