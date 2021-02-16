import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { tap } from 'rxjs/operators'; 

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

  demoMethod()
  {
    return "Hello World!"
  }

}
