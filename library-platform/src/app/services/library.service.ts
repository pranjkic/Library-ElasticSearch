import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UploadModelBook, SimpleQuery, AdvancedQuery } from '../model/model'

// const httpOptions = {
//   headers: new HttpHeaders({ 'Content-Type': 'text/plain;charset=UTF-8','responseType': 'applicatison/json'  })
// };

const headers = {
  headers: new HttpHeaders().set('responseType', 'text')
};

const hdrs = {
  headers: new HttpHeaders({responseType: 'text'})
};

@Injectable({
  providedIn: 'root'
})
export class LibraryService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getSomething(): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
        "Content-Type": "text/html;charset=UTF-8"
      })
    };
  
    const url = `${this.apiServerUrl}/index/getSomething`;
    var result = this.http.get<any>(url,httpOptions);
    return result;
  }

  public indexBook(book: FormData): Observable<{}>{
    const url = `${this.apiServerUrl}/indexbook/add`;
    return this.http.post(url, book, {observe: 'response'});
  }

  public querySearch(simpleQuery: SimpleQuery): Observable<{}>{
    const url = `${this.apiServerUrl}/search/queryParser`;
    return this.http.post(url, simpleQuery, {observe: 'response'});
  }

  public termSearch(simpleQuery: SimpleQuery): Observable<{}>{
    const url = `${this.apiServerUrl}/search/term`;
    return this.http.post(url, simpleQuery, {observe: 'response'});
  }

  public booleanQuerySearch(simpleQuery: AdvancedQuery): Observable<{}>{
    const url = `${this.apiServerUrl}/search/boolean`;
    return this.http.post(url, simpleQuery, {observe: 'response'});
  }

  downloadPDF(internalId : string): Observable<Blob>
  {
      //filename = "flnm";
      //const url = this.apiServerUrl + '/generatepdf/'+ filename;
      const url = `${this.apiServerUrl}/generatepdf/${internalId}`;
      alert(url);
      const headers = new HttpHeaders({ 'Content-Type': 'application/json', responseType : 'blob'});
      return this.http.get<Blob>(url, { headers : headers,responseType : 'blob' as 'json'});
  }

}
