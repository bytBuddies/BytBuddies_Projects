USE [emsDatabase]
GO

/****** Object:  Table [dbo].[user_register]    Script Date: 16-07-2024 18:25:43 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user_register](
	[id] [varchar](50) NOT NULL,
	[email] [varchar](30) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[first_name] [varchar](25) NOT NULL,
	[last_name] [varchar](25) NOT NULL,
	[phone] [bigint] NOT NULL,
	[role_id] [varchar](50) NOT NULL,
	[is_first_login] [bit] NOT NULL,
	[email_varified] [bit] NOT NULL,
	[created_at] [timestamp] NOT NULL
) ON [PRIMARY]
GO

