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

    constructor(title, author, genre, ISBN, keyWords, publisher, publishingYear, publishingPlace, pageNumber, sysnopys, lectoringData, directors, content){
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
    }
}
