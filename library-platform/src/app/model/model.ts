export class Model {
}

export class UploadModelBook{
    title: string;
    author: string;
    genre: string;
    ISBN: string;
    keywords: string;
    publisher: string;
    publishingyear: number;
    publishingplace: string; 
    pagenumber: number;    
    sysnopys: string;       
    lectoringdata: string;
    directors: string;        
    content: string;
    files: File;

    constructor(title, author, genre, ISBN, keyWords, publisher, publishingYear, publishingPlace, 
                pageNumber, sysnopys, lectoringData, directors, content, files){

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
        this.keywords = keyWords;
        this.publisher = publisher;
        this.publishingyear = publishingYear;
        this.publishingplace = publishingPlace;
        this.pagenumber = pageNumber;
        this.sysnopys = sysnopys;
        this.lectoringdata = lectoringData;
        this.directors = directors;
        this.content = content;
        this.files = files;
    }
}

export class SimpleQuery{
    field: string;
    value: string;

    constructor(field, value){
        this.field = field;
        this.value = value;
    }
}
