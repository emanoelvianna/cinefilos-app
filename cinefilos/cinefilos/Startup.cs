using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(cinefilos.Startup))]
namespace cinefilos
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
