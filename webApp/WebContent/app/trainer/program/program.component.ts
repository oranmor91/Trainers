import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PROGRAM} from "../../Model/program.model";

@Component({
  selector: 'app-program',
  templateUrl: './program.component.html',
  styleUrls: ['./program.component.css']
})
export class ProgramComponent implements OnInit {
  private program:PROGRAM;

  constructor(private dataService:DataService,
              private router: Router) {

  }
  ngOnInit() {
    this.getTrainerProgram()
  }

    private getTrainerProgram() {
    this.dataService.getUserProgram(Number(this.dataService.profile.id))
      .subscribe((data)=> {
        if (data != null) {
        this.program = <PROGRAM> data;
        if(this.program.rmData.length === 0){
          this.router.navigate(['rm']);
        } else {
          this.router.navigate(['current-program']);
        }
      }
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }

}
