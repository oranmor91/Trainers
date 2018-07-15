import { PROGRAM } from '../../../Model/program.model';
import { PROGRAMTYPE } from '../../../Model/programType.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-program',
  templateUrl: './create-program.component.html',
  styleUrls: ['./create-program.component.css']
})
export class CreateProgramComponent implements OnInit {

   program:PROGRAM = new PROGRAM();

 public programType : any = PROGRAMTYPE;
  
 constructor(private dataService:DataService,
              private router: Router) { }

  ngOnInit() {
  }

  saveProgram(){
        this.router.navigate(['programs']);
  }
}
