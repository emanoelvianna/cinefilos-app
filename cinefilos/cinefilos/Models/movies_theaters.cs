using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace cinefilos.Models
{
    public class movies_theaters
    {
        public int room_number { get; set; }
        public int max_qt;  
        public enum status { open, close, on_cleaning}
        private List<poltrona> list_poltrona;

        public movies_theaters() {
            list_poltrona = new List<poltrona>(max_qt);

        }

        
    }
}